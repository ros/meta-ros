# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2022 Wind River Systems, Inc.

inherit python3targetconfig

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://reverse-deprecated.patch \
            file://reverse-types.patch"

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-generator-py-native \
"
