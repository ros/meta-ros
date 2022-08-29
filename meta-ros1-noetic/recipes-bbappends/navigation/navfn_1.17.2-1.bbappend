# Copyright (c) 2019-2020 LG Electronics, Inc.

ROS_BUILD_DEPENDS:remove = "${ROS_UNRESOLVED_DEP-netpbm}"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-uncommend-CheckIncludeFile-include.patch"
