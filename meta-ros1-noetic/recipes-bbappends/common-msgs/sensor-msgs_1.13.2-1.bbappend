# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-pyyaml-native \
"

# QA Issue: File /opt/ros/noetic/lib/python3.13/site-packages/sensor_msgs/__pycache__/__init__.cpython-313.pyc in package sensor-msgs contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_prefix}/lib/python3.13/site-packages/sensor_msgs/__pycache__/__init__.cpython-313.pyc
}
