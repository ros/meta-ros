# Copyright (c) 2019-2021 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    python3-empy-native \
    rcutils-native \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Remove-use-of-std-allocator-rebind-1678.patch"
