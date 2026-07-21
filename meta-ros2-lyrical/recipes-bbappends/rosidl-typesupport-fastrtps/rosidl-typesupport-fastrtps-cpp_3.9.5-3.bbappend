# Copyright (c) 2019-2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://fix-format-security.patch"

ROS_BUILD_DEPENDS += "\
    fastcdr \
"
