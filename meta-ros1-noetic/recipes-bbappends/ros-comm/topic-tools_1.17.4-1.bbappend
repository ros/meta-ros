# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

# QA Issue: File /opt/ros/noetic/lib/python3.13/site-packages/topic_tools/__pycache__/__init__.cpython-313.pyc in package topic-tools contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_prefix}/lib/python3.13/site-packages/topic_tools/__pycache__/__init__.cpython-313.pyc
}
