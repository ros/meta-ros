# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += " \
    geographiclib \
"

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://add-geographiclib-find-package.patch"
