# Copyright (c) 2022 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
    python3-numpy-native \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://do-not-set-compiler-options.patch"
