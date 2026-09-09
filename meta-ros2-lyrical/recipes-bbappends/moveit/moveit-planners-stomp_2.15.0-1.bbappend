# Copyright (c) 2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://add-bullet-dependency.patch"

ROS_BUILD_DEPENDS += " eigen3-cmake-module"

ROS_BUILDTOOL_DEPENDS += "\
    generate-parameter-library-py-native \
"
