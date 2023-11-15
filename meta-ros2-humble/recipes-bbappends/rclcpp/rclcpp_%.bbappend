# Copyright (c) 2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-fix-libdir.patch"

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-adapter-native \
"
