# Copyright (c) 2023-2025 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-pyqt-bindings-dir.patch"

ROS_BUILD_DEPENDS:remove = "python3-pyqt5"
ROS_BUILD_DEPENDS:append = " python3-pyqt6"

ROS_EXEC_DEPENDS:remove = "python3-pyqt5"
ROS_EXEC_DEPENDS:append = " python3-pyqt6"

inherit python3targetconfig

DEPENDS += "sip-native python3-pyqt-builder-native"
