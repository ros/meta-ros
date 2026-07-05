# Copyright (c) 2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-ament-target-dependencies.patch"

ROS_BUILD_DEPENDS += " \
    ament-cmake-ros-native \
"
