# Copyright (c) 2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://fix-typo-in-lexy-input_location-comparison.patch"

ROS_BUILD_DEPENDS += " \
    ament-cmake-gtest \
    googletest \
"
