# Copyright (c) 2023-2025 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

# SRC_URI += "file://adding-sip5-integration.patch"
ROS_BRANCH = "branch=sloretz__use_sip_build_qt5_qt6"
SRC_URI = "git://github.com/ros-visualization/python_qt_binding.git;${ROS_BRANCH};protocol=https"
SRCREV = "665f1d6ca6bcbaf2b0637b0bb458b0528a41f0c9"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-pyqt-bindings-dir.patch"

ROS_BUILD_DEPENDS:remove = "python3-pyqt5"
ROS_BUILD_DEPENDS:append = " python3-pyqt6"

ROS_EXEC_DEPENDS:remove = "python3-pyqt5"
ROS_EXEC_DEPENDS:append = " python3-pyqt6"

inherit python3targetconfig

DEPENDS += "sip-native python3-pyqt-builder-native"
