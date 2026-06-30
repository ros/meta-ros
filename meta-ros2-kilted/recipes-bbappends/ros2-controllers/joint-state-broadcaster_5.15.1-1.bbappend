# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://disable-compiler-options.patch"

ROS_BUILDTOOL_DEPENDS += " \
    generate-parameter-library-py-native \
"
