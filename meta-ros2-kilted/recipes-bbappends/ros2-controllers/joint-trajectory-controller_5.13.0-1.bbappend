# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://disable-compiler-options.patch"

ROS_BUILDTOOL_DEPENDS += " \
    generate-parameter-library-py-native \
"
