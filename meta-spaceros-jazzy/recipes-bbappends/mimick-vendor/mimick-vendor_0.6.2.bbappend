# Copyright (c) 2025 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += "mimick"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-system-mimick.patch"
