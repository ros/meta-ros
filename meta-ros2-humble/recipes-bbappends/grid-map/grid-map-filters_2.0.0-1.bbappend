# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2022-2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

DEPENDS += "tbb"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Modify-tbb-pkg-check.patch"

inherit pkgconfig
