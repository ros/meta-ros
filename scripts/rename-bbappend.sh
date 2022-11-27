#!/bin/bash
#
# Usage: cd meta-ros
#        scripts/rename-bbappend.sh ROS_DISTRO_LAYER SYNC_COMMIT_ID
#
# Uses the sync commit to automatically rename all the bbappend files in git
#
# Copyright (c) 2019-2021 LG Electronics, Inc.
# Copyright (c) 2019-2022 Wind River Systems, Inc.

readonly SCRIPT_NAME="rename-bbappends"
readonly SCRIPT_VERSION="1.0.0"

usage() {
    echo "Usage: cd meta-ros"
    echo "       scripts/rename-bbappend.sh ROS_DISTRO_LAYER SYNC_COMMIT_ID"
    exit 1
}

if [ "$1" = "--version" ]; then
    echo "$SCRIPT_NAME $SCRIPT_VERSION"
    exit
fi

[ $# -ne 2 ] && usage

ROS_DISTRO_LAYER="$1"
SYNC_COMMIT_ID="$2"

GIT_SYNC_LIST=$(git log --format=%B -n 1 ${SYNC_COMMIT_ID})

if [ ! -d ${ROS_DISTRO_LAYER} ]; then
    echo "ERROR: Could not find directory ${ROS_DISTRO_LAYER}"
    exit 1
fi

echo "${GIT_SYNC_LIST}" | head -n1 | grep "Sync to files/humble/generated/cache.yaml as of" 2>&1 > /dev/null
if [ $? -ne 0 ]; then
    echo "ERROR: Commit ${SYNC_COMMIT_ID} was not a sync commit"
    exit 1
fi

while IFS= read -r line; do
    RECIPE_NAME=$(echo "${line}" | cut -d' ' -f2)
    RECIPE_VERSION=$(echo "${line}" | cut -d' ' -f3)
    BBAPPEND_FILES=$(find ${ROS_DISTRO_LAYER}/recipes-* -name "${RECIPE_NAME}_*.bbappend")
    if [ -n "${BBAPPEND_FILES}" ]; then
        while IFS= read -r OLD_FILENAME; do
            OLD_VERSION=$(basename ${OLD_FILENAME} | sed 's/.*_\(.*\).bbappend$/\1/')
            OLD_PATH=$(dirname ${OLD_FILENAME})
            NEW_FILENAME="${OLD_PATH}/${RECIPE_NAME}_${RECIPE_VERSION}.bbappend"
            if [ "${OLD_VERSION}" == "%" ]; then
                continue
            fi
            if [ "${OLD_FILENAME}" != "${NEW_FILENAME}" ]; then
                echo "Renaming ${RECIPE_NAME} ${OLD_VERSION} -> ${RECIPE_VERSION}"
                git mv ${OLD_FILENAME} ${NEW_FILENAME}
            else
                echo "Skipping ${RECIPE_NAME} ${RECIPE_VERSION}" 
            fi
        done <<< "${BBAPPEND_FILES}"
    fi
done <<< "${GIT_SYNC_LIST}"
