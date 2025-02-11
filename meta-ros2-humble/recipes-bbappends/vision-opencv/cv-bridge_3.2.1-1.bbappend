# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "Apache-2.0 & BSD-3-Clause"

ROS_BUILD_DEPENDS:remove = "python-numpy"
ROS_BUILD_DEPENDS:remove = "python3-numpy"

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-numpy-native \
"

# QA Issue: File /opt/ros/rolling/share/cv_bridge/cmake/cv_bridge-extras.cmake in package cv-bridge-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_datadir}/cv_bridge/cmake/cv_bridge-extras.cmake
}
