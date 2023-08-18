# Copyright (c) 2020-2021 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-adapter \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-use-pkg-config-to-find-sdl2.patch"

inherit pkgconfig
