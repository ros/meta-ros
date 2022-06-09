# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

# Fix for Honister release only:
inherit distutils3-base

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-adapter \
    python3-numpy-native \
"

# FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
# SRC_URI += "file://0001-CMakeLists-search-for-Python3-Development.patch"

