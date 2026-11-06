# Copyright (c) 2026 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += "\
    generate-parameter-library-py-native \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://disable-compiler-options.patch"
