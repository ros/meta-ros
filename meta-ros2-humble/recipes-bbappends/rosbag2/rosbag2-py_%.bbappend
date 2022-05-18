# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-adapter \
    python3-numpy-native \
"

# FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
# SRC_URI += "file://0001-CMakeLists-search-for-Python3-Development.patch"

# ERROR: do_package: Files/directories were installed but not shipped in any package
#
PNQAFIX = "rosbag2_py"
do_install:append() {
    mkdir -p ${D}${libdir}/python3.9/site-packages/
    mv ${D}${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX}* ${D}${libdir}/python3.9/site-packages/
    rm -r ${D}/home
}