# Copyright (c) 2021 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-adapter \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists-search-for-Python3-Development.patch"
