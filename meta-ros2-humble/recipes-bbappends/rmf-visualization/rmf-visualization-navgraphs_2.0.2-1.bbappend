# Copyright (c) 2023 Wind River Systems, Inc.


FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://improve-linking-times.patch"

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
    ament-cmake-ros-native \
    ament-cmake-core-native \
    ament-package-native \
"

EXTRA_OECMAKE += " --debug-find "
inherit pkgconfig
