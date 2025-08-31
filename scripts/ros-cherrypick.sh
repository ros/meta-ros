#!/bin/bash
#
# Usage: cd meta-ros
#        scripts/ros-cherrypick.sh OLD_DISTRO_LAYER NEW_DISTRO_LAYER COMMIT_START COMMIT_END
#
#    eg. scripts/ros-cherrypick.sh meta-ros2-humble meta-ros2-iron 791990e9 28e09796
#
# Automates the porting of patches between ROS distro layers within the same 
# Yocto release / branch. It iterates over the commits in a specified range and automatically
# renames the Bitbake recipe files based on the versions found in the new ROS distro layer.
#
# It also automatically filters out files from ROS packages that no longer exist.  If a patch
# file no longer contains any changes, the commit is discarded.
#
# The result is a series of patch files created in the local directory based on each commit.
# One may make any necessary changes to the commit messages or additional fixes for things
# that cannot be automated.  When ready, the patches may be applied with git-am.
#
# Based on rename-bbappend.sh.
#
# Copyright (c) 2019-2021 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

readonly SCRIPT_NAME="ros-cherrypick.sh"
readonly SCRIPT_VERSION="1.0.0"

usage() {
    echo "Usage: cd meta-ros"
    echo "       scripts/ros-cherrypick.sh OLD_DISTRO_LAYER NEW_DISTRO_LAYER COMMIT_START COMMIT_END"
    exit 1
}

echoerr() { cat <<< "$@" 1>&2; }

DEBUG=0
DRYRUN=0

if [ "$1" = "--version" ]; then
    echo "$SCRIPT_NAME $SCRIPT_VERSION"
    exit
fi

if [ "$1" = "--debug" ]; then
    DEBUG=1
    shift
fi

if [ "$1" = "--dry-run" ]; then
    DRYRUN=1
    shift
fi


[ $# -ne 4 ] && usage

OLD_DISTRO_LAYER="$1"
NEW_DISTRO_LAYER="$2"
COMMIT_START="$3"
COMMIT_END="$4"

GIT_REV_LIST=$(git rev-list --reverse ${COMMIT_START}..${COMMIT_END})

# rename_bitbake_recipe OLD_DISTRO_LAYER NEW_DISTRO_LAYER OLD_FILEPATH
function rename_bitbake_recipe() {
    rc=1
    OLD_DISTRO_LAYER="$1"
    OLD_DISTRO_NAME=$(echo ${OLD_DISTRO_LAYER} | sed 's/^meta-ros2-//')
    NEW_DISTRO_LAYER="$2"
    NEW_DISTRO_NAME=$(echo ${NEW_DISTRO_LAYER} | sed 's/^meta-ros2-//')
    OLD_FILEPATH="$3"

    OLD_DISTRO=$(echo ${OLD_FILEPATH} | sed 's/^\([^\/]*\)\/.*$/\1/')
    OLD_DISTRO_NAME=$(echo ${OLD_DISTRO} | sed 's/^meta-ros2-//')
    OLD_PATH=$(dirname ${OLD_FILEPATH} | sed 's/^[^\/]*\/\(.*\)$/\1/')
    OLD_FILENAME=$(basename ${OLD_FILEPATH})
    OLD_FILEBASE=$(echo ${OLD_FILENAME} | sed 's/^\(.*\)\.[^\.]*$/\1/')
    OLD_NAME=$(echo ${OLD_FILEBASE} | sed 's/^\([^_]*\)*_\(.*\)/\1/')
    OLD_VERSION=$(echo ${OLD_FILEBASE} | sed 's/^\([^_]*\)*_\(.*\)/\2/')
    OLD_EXTENSION=$(echo ${OLD_FILENAME} | sed 's/^.*\.\([^\.]*\)$/\1/')

    if [ "${DEBUG}" == "1" ]; then
        echoerr "DEBUG: Recipe metadata ${OLD_DISTRO}:${OLD_PATH}:${OLD_FILEBASE}:${OLD_EXTENSION} ${OLD_NAME}:${OLD_VERSION}"
    fi

    if [ "${OLD_DISTRO}" != "${OLD_DISTRO_LAYER}" ]; then
        echoerr "ERROR: Skipping ${OLD_FILEPATH} not in ${OLD_DISTRO_LAYER}"
        exit 1
    fi 

    if [ "${OLD_NAME}" == "packagegroup-ros-world-${OLD_DISTRO_NAME}" ]; then
        EXISTING_PATH=$(find ${NEW_DISTRO_LAYER} -path "${NEW_DISTRO_LAYER}/${OLD_PATH}/*" -name "packagegroup-ros-world-${NEW_DISTRO_NAME}.bb")
    else
        EXISTING_PATH=$(find ${NEW_DISTRO_LAYER} -path "${NEW_DISTRO_LAYER}/${OLD_PATH}/*" -name "${OLD_NAME}_.*.${OLD_EXTENSION}")
    fi

    if [ "${DEBUG}" == "1" ]; then
        if [ -n "${EXISTING_PATH}" ]; then
            echoerr "DEBUG: Found ${EXISTING_PATH}"
        else
            echoerr "DEBUG: Not found ${OLD_FILENAME}"
        fi
    fi

    FOUND_LINECOUNT=$(echo ${EXISTING_PATH} | wc -l)
    if [ -n "${EXISTING_PATH}"  ] && [ ${FOUND_LINECOUNT} -eq 1 ]; then
        if [ "${DEBUG}" == "1" ]; then
            echoerr "DEBUG: Found existing file: ${EXISTING_PATH}"
        fi
        NEW_FILEPATH="${EXISTING_PATH}"
        rc=0
    elif [ ${FOUND_LINECOUNT} -gt 1 ]; then
        echoerr "ERROR: Found multiple results: ${EXISTING_PATH}"
        exit 1
    else
        GENERATED_PATH=$(find ${NEW_DISTRO_LAYER} -path "${NEW_DISTRO_LAYER}/generated-recipes/*" -name "${OLD_NAME}_*.bb")
        FOUND_LINECOUNT=$(echo ${GENERATED_PATH} | wc -l)
        if [ -n "${GENERATED_PATH}"  ] && [ ${FOUND_LINECOUNT} -eq 1 ]; then
            if [ "${DEBUG}" == "1" ]; then
                echoerr "DEBUG: Found generated-recipe: ${GENERATED_PATH}"
            fi
            NEW_DIR=$(dirname ${GENERATED_PATH} | cut -d/ -f3-)
            if [ "${OLD_VERSION}" == "%" ]; then
                NEW_VERSION="%"
            else
                NEW_VERSION=$(basename ${GENERATED_PATH} | sed 's/.*_\(.*\).bb\(append\)\?$/\1/')
            fi
            NEW_PATH="${NEW_DISTRO_LAYER}/${OLD_PATH}"
            NEW_NAME="${OLD_NAME}_${NEW_VERSION}.${OLD_EXTENSION}"
            NEW_FILEPATH="${NEW_PATH}/${NEW_NAME}"
            rc=0
        elif [ ${FOUND_LINECOUNT} -gt 1 ]; then
            echoerr "ERROR: Found multiple results: ${GENERATED_PATH}"
            exit 1
        else
            if [ "${OLD_EXTENSION}" == "bbappend" ]; then
                echoerr "WARNING: Could not determine new path for ${OLD_NAME}"
            else
                NEW_PATH="${NEW_DISTRO_LAYER}/${OLD_PATH}"
                NEW_NAME="${OLD_NAME}_${OLD_VERSION}.${OLD_EXTENSION}"
                NEW_FILEPATH="${NEW_PATH}/${NEW_NAME}"
                rc=0
            fi
        fi
    fi
    if [ $rc -eq 0 ]; then
        echo "${NEW_FILEPATH}"
    fi
    return $rc
}

# Loop over every commit
NEW_PATCH_COUNT=0
while IFS= read -r COMMIT_ID; do
    if [ "${DEBUG}" == "1" ]; then
        echoerr "DEBUG: Processing commit ${COMMIT_ID}"
    fi

    # Create a list of files from the commit
    COMMIT_FILE_LIST=$(git show --no-renames $COMMIT_ID | diffstat -p1 -l)
    FILTER_LIST=""
    REPLACE_LIST=""

    # Iterate over each file
    while IFS= read -r OLD_FILEPATH; do
        if [ -z "${OLD_FILEPATH}" ]; then
            echo "ERROR: Commit ${COMMIT_ID} has no changed files"
            exit 1
        fi

        EXTENSION=$(basename ${OLD_FILEPATH} | sed 's/^.*\.\([^\.]*\)$/\1/')

        NEW_FILEPATH=""
        OLD_DISTRO_NAME=$(echo ${OLD_DISTRO_LAYER} | sed 's/^meta-ros2-//')
        NEW_DISTRO_NAME=$(echo ${NEW_DISTRO_LAYER} | sed 's/^meta-ros2-//')

        case "${OLD_FILEPATH}" in
            ${OLD_DISTRO_LAYER}*)
                # Bitbake recipes and bbappends need updates to their version
                # All other filenames should pass through unchanged
                case "${EXTENSION}" in
                    bb)
                        NEW_FILEPATH=$(rename_bitbake_recipe "${OLD_DISTRO_LAYER}" "${NEW_DISTRO_LAYER}" "${OLD_FILEPATH}")
                        ;;
                    bbappend)
                        NEW_FILEPATH=$(rename_bitbake_recipe "${OLD_DISTRO_LAYER}" "${NEW_DISTRO_LAYER}" "${OLD_FILEPATH}")
                        ;;
                    bbclass)
                        NEW_FILEPATH=$(echo "${OLD_FILEPATH}" | sed "s/^${OLD_DISTRO_LAYER}/${NEW_DISTRO_LAYER}/g")
                        NEW_FILEPATH=$(echo "${NEW_FILEPATH}" | sed "s/${OLD_DISTRO_NAME}/${NEW_DISTRO_NAME}/g")
                        ;;
                    cmake)
                        NEW_FILEPATH=$(echo "${OLD_FILEPATH}" | sed "s/^${OLD_DISTRO_LAYER}/${NEW_DISTRO_LAYER}/g")
                        NEW_FILEPATH=$(echo "${NEW_FILEPATH}" | sed "s/${OLD_DISTRO_NAME}/${NEW_DISTRO_NAME}/g")
                        ;;
                    conf)
                        NEW_FILEPATH=$(echo "${OLD_FILEPATH}" | sed "s/^${OLD_DISTRO_LAYER}/${NEW_DISTRO_LAYER}/g")
                        NEW_FILEPATH=$(echo "${NEW_FILEPATH}" | sed "s/${OLD_DISTRO_NAME}/${NEW_DISTRO_NAME}/g")
                        ;;
                    diffme)
                        NEW_FILEPATH=$(echo "${OLD_FILEPATH}" | sed "s/^${OLD_DISTRO_LAYER}/${NEW_DISTRO_LAYER}/g")
                        NEW_FILEPATH=$(echo "${NEW_FILEPATH}" | sed "s/${OLD_DISTRO_NAME}/${NEW_DISTRO_NAME}/g")
                        ;;
                    do_configure)
                        NEW_FILEPATH=$(echo "${OLD_FILEPATH}" | sed "s/^${OLD_DISTRO_LAYER}/${NEW_DISTRO_LAYER}/g")
                        NEW_FILEPATH=$(echo "${NEW_FILEPATH}" | sed "s/${OLD_DISTRO_NAME}/${NEW_DISTRO_NAME}/g")
                        ;;
                    inc)
                        NEW_FILEPATH=$(echo "${OLD_FILEPATH}" | sed "s/^${OLD_DISTRO_LAYER}/${NEW_DISTRO_LAYER}/g")
                        NEW_FILEPATH=$(echo "${NEW_FILEPATH}" | sed "s/${OLD_DISTRO_NAME}/${NEW_DISTRO_NAME}/g")
                        ;;
                    list)
                        NEW_FILEPATH=$(echo "${OLD_FILEPATH}" | sed "s/^${OLD_DISTRO_LAYER}/${NEW_DISTRO_LAYER}/g")
                        NEW_FILEPATH=$(echo "${NEW_FILEPATH}" | sed "s/${OLD_DISTRO_NAME}/${NEW_DISTRO_NAME}/g")
                        ;;
                    patch)
                        NEW_FILEPATH=$(echo "${OLD_FILEPATH}" | sed "s/^${OLD_DISTRO_LAYER}/${NEW_DISTRO_LAYER}/g")
                        ;;
                    pc)
                        NEW_FILEPATH=$(echo "${OLD_FILEPATH}" | sed "s/&${OLD_DISTRO_LAYER}/${NEW_DISTRO_LAYER}/g")
                        ;;
                    sh)
                        NEW_FILEPATH=$(echo "${OLD_FILEPATH}" | sed "s/^${OLD_DISTRO_LAYER}/${NEW_DISTRO_LAYER}/g")
                        NEW_FILEPATH=$(echo "${NEW_FILEPATH}" | sed "s/${OLD_DISTRO_NAME}/${NEW_DISTRO_NAME}/g")
                        ;;
                    yaml)
                        NEW_FILEPATH=$(echo "${OLD_FILEPATH}" | sed "s/^${OLD_DISTRO_LAYER}/${NEW_DISTRO_LAYER}/g")
                        NEW_FILEPATH=$(echo "${NEW_FILEPATH}" | sed "s/${OLD_DISTRO_NAME}/${NEW_DISTRO_NAME}/g")
                        ;;
                    *)
                        echoerr "ERROR: Found unexpected extension: ${EXTENSION} on ${OLD_FILEPATH}"
                        exit 1
                        ;;    
                esac
                ;;
            *)
                ;;
        esac


        # If a newer version was not found we must add it to a list for filtering out
        if [ -z "${NEW_FILEPATH}" ]; then
            # echo "INFO: This is empty ${OLD_FILEPATH}"
            FILTER_LIST=$(echo -e "${OLD_FILEPATH}\n${FILTER_LIST}")
        else
            # echo "Replace ${OLD_FILEPATH}:${NEW_FILEPATH}"
            REPLACE_LIST=$(echo -e "${OLD_FILEPATH}:${NEW_FILEPATH}\n${REPLACE_LIST}")
        fi
    done <<< "${COMMIT_FILE_LIST}"

    # Check if there are files in this commit to filter out
    if [ -n "${FILTER_LIST}" ]; then
        EXCLUDE_ARGS=""

        # Create a list of files to exclude to pass to filterdiff
        while IFS= read -r EXCLUDE_FILE; do
            EXCLUDE_ARGS="${EXCLUDE_ARGS} --exclude ${EXCLUDE_FILE}"
        done <<< "${FILTER_LIST}"

        NEW_PATCH=$(git format-patch --stdout -1 --no-stat ${COMMIT_ID} | filterdiff --strip-match=1 ${EXCLUDE_ARGS})
        # Check to see if any files remain in the new commit after filtering
        NEW_FILES=$(echo "${NEW_PATCH}" | lsdiff)

        # Remove new file mode lines for removed files
        while IFS= read -r EXCLUDE_FILE; do
            NEW_PATCH=$(echo "${NEW_PATCH}" | sed -e "\|^diff --git a/${EXCLUDE_FILE}|,\|^index |d")
        done <<< "${FILTER_LIST}"

        SUBJECT=$(git show --format="%s" ${COMMIT_ID} -s)
        if [ -n "${NEW_FILES}" ]; then
            echoerr "INFO: Commit ${COMMIT_ID} \"${SUBJECT}\""
        else
            echoerr "WARNING: Commit ${COMMIT_ID} \"${SUBJECT}\" is empty"
            echo "Skipping ${COMMIT_ID}"
            continue
        fi
    else
        SUBJECT=$(git show --format="%s" ${COMMIT_ID} -s)
        NEW_PATCH=$(git format-patch --stdout -1 --no-stat ${COMMIT_ID})

        echoerr "INFO: Commit ${COMMIT_ID} \"${SUBJECT}\""
    fi

    # Rename the diff headers
    while IFS= read -r REPLACE_FILEPATH; do
        OLD_FILE=$(echo "${REPLACE_FILEPATH}" | cut -d: -f1)
        NEW_FILE=$(echo "${REPLACE_FILEPATH}" | cut -d: -f2)
        NEW_PATCH=$(echo "${NEW_PATCH}" | sed -e "s|^Subject:\(.*\){${OLD_DISTRO_NAME}}\(.*\)|Subject:\1{${NEW_DISTRO_NAME}}\2|")
        NEW_PATCH=$(echo "${NEW_PATCH}" | sed -e "s|^diff --git a/${OLD_FILE}|diff --git a/${NEW_FILE}|g")
        NEW_PATCH=$(echo "${NEW_PATCH}" | sed -e "s|^\(diff --git .*\)b/${OLD_FILE}|\1b/${NEW_FILE}|g")
        NEW_PATCH=$(echo "${NEW_PATCH}" | sed -e "s|^--- a/${OLD_FILE}|--- a/${NEW_FILE}|g")
        NEW_PATCH=$(echo "${NEW_PATCH}" | sed -e "s|^+++ b/${OLD_FILE}|+++ b/${NEW_FILE}|g")
    done <<< "${REPLACE_LIST}"

    if [ "${DEBUG}" == "1" ]; then
        echo "${NEW_PATCH}" | colordiff
    fi

    echo "Applying patch for ${COMMIT_ID}"
    if [ "${DRYRUN}" == "1" ]; then
        echo "${NEW_PATCH}" | git apply --check
    else
        echo "${NEW_PATCH}" | git apply --stat
    fi

    # Output the new patch to a file
    NEW_PATCH_COUNT=`expr $NEW_PATCH_COUNT + 1`
    PATCH_OUTPUT_FILENAME=$(printf "%04d-%s.patch\n" ${NEW_PATCH_COUNT} ${COMMIT_ID})
    echo "${NEW_PATCH}" > ${PATCH_OUTPUT_FILENAME}

    echo
done <<< "${GIT_REV_LIST}"
