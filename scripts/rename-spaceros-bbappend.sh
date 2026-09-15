#!/bin/bash
#
# Usage: cd meta-ros
#        scripts/rename-bbappend.sh SPACE_ROS_DISTRO SYNC_COMMIT_ID
#
# Scans the bbappends in the Space ROS layer to automatically rename
# all the bbappend files to match the BitBake recipe versions.
#
# Copyright (c) 2019-2021 LG Electronics, Inc.
# Copyright (c) 2019-2022 Wind River Systems, Inc.

readonly SCRIPT_NAME="rename-spaceros-bbappends"
readonly SCRIPT_VERSION="1.0.0"

usage() {
    echo "Usage: cd meta-ros"
    echo "       scripts/${SCRIPT_NAME}.sh SPACE_ROS_DISTRO"
    echo "       "
    echo "       e.g. scripts/${SCRIPT_NAME}.sh jazzy"
    exit 1
}

if [ "$1" = "--version" ]; then
    echo "$SCRIPT_NAME $SCRIPT_VERSION"
    exit
fi

[ $# -ne 1 ] && usage

SPACE_ROS_DISTRO="$1"

SPACE_ROS_DISTRO_LAYER=$(ls -d meta-spaceros-${SPACE_ROS_DISTRO})

if [ ! -d ${SPACE_ROS_DISTRO_LAYER} ]; then
    echo "ERROR: Could not find directory ${SPACE_ROS_DISTRO_LAYER}"
    exit 1
fi

SPACE_ROS_DISTRO_NAME=$(grep -h 'ROS[12]_DISTRO =' ${SPACE_ROS_DISTRO_LAYER}/conf/ros-distro/include/*/ros-distro.inc | sed 's/.*= "\(.*\)"/\1/g')
if [ -z "${SPACE_ROS_DISTRO_NAME}" ]; then
    echo "ERROR: Could not find ROS distro name in ${SPACE_ROS_DISTRO_LAYER}"
    exit 1
fi

SPACE_ROS_GENERATED_RECIPE_DIRS=$(ls -d ${SPACE_ROS_DISTRO_LAYER}/generated-recipes-*)

for DIR in ${SPACE_ROS_GENERATED_RECIPE_DIRS}; do
    SUBDIR=${DIR/${SPACE_ROS_DISTRO_LAYER}\/generated-recipes-}
    # echo "Subdir: ${SUBDIR}"
    echo "Scanning ${SPACE_ROS_DISTRO_LAYER}/recipes-bbappends-${SUBDIR}"
    if [ -d "${SPACE_ROS_DISTRO_LAYER}/recipes-bbappends-${SUBDIR}" ]; then
        BBAPPENDS_LIST=$(find "${SPACE_ROS_DISTRO_LAYER}/recipes-bbappends-${SUBDIR}" -name '*bbappend')
    fi

    for FILE in ${BBAPPENDS_LIST}; do
        FILE_NAME=$(basename ${FILE})
        FILE_PATH=$(dirname ${FILE})
        FILE_BASE=${FILE_NAME%.bbappend}
        BBAPPEND_NAME=${FILE_BASE%%_*}
        BBAPPEND_VERSION=${FILE_BASE##*_}

        # echo "${FILE_NAME}: ${BBAPPEND_NAME} ${BBAPPEND_VERSION}"

        if [ "${BBAPPEND_VERSION}" == "%" ]; then
            # The bbappend applies to any version and does not need to be renamed
            continue
        fi

        RECIPE_FILE_PATH=$(find ${SPACE_ROS_DISTRO_LAYER}/generated-recipes-${SUBDIR} -name "${BBAPPEND_NAME}_*bb")

        if [ ! -e "${RECIPE_FILE_PATH}" ]; then
            echo "${BBAPPEND_NAME}: File not found ${RECIPE_FILE_PATH}"
        fi

        RECIPE_FILE_BASE=$(basename ${RECIPE_FILE_PATH%.bb})
        RECIPE_FILE_NAME=${RECIPE_FILE_BASE%%_*}
        RECIPE_FILE_VERSION=${RECIPE_FILE_BASE##*_}

        # echo "${RECIPE_FILE_PATH}: ${RECIPE_FILE_NAME} ${RECIPE_FILE_VERSION}"

        if [ "${BBAPPEND_VERSION}" == "${RECIPE_FILE_VERSION}" ]; then
            # The bbappend versions have not changed.
            continue
        fi

        echo "Rename: ${BBAPPEND_NAME}: ${BBAPPEND_VERSION} --> ${RECIPE_FILE_VERSION}"
        if [ ! -e ${FILE_PATH}/${BBAPPEND_NAME}_${BBAPPEND_VERSION}.bbappend ]; then
            echo "Could not file bbappend file: ${FILE_PATH}/${BBAPPEND_NAME}_${BBAPPEND_VERSION}.bbappend"
        fi
        git mv ${FILE_PATH}/${BBAPPEND_NAME}_${BBAPPEND_VERSION}.bbappend ${FILE_PATH}/${BBAPPEND_NAME}_${RECIPE_FILE_VERSION}.bbappend
    done

    # If there are changes commit them
    #   0 no staged changes
    #   1 staged changes
    #  >1 error
    git diff --cached --quiet
    if [ $? -eq 1 ]; then
        git commit -s -m "{${SPACE_ROS_DISTRO_NAME}} Rename bbappends in recipes-bbappends-${SUBDIR}

Rename bbappends in recipes-bbappends-${SUBDIR} to match new versions"
    fi
done

exit 
