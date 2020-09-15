# Copyright (c) 2019-2020 LG Electronics, Inc.

ROS_BUILD_DEPENDS_remove = "${ROS_UNRESOLVED_PLATFORM_PKG_netpbm}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-uncommend-CheckIncludeFile-include.patch"
