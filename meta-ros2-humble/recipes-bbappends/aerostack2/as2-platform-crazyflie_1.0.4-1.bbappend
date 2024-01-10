# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += " \
    crazyflie-cpp \
    geographiclib \
"

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://add-geographiclib-find-package.patch"

do_install:append() {
    sed -i '1c#!/usr/bin/env python3' ${D}${libdir}/as2_platform_crazyflie/aideck_node.py
}
