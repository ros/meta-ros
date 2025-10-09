# Copyright (c) 2025 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI += "file://use-system-zenoh.patch"

ROS_BUILD_DEPENDS += " zenoh-c zenoh-cpp"
