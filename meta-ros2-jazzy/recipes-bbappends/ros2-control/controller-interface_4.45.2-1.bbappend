# Copyright (c) 2022-2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-cmake-targets.patch"

ROS_BUILDTOOL_DEPENDS += " \
    ament-cmake-ros-native \
    python3-numpy-native \
"
