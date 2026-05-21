# Copyright (c) 2023-2025 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-pyqt-bindings-dir.patch"

# This resolves the following error:
#   To use a cross-compiled Qt, please set the QT_HOST_PATH cache variable to
#   the location of your host Qt installation.
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt6-layer', 'qt6-cmake', '', d)}

# tag: release/rolling/python_qt_binding/2.5.4-2
SRCREV = "976c34ff39ef778a6d8976ccb2b54128e7e106dd"

ROS_BUILD_DEPENDS:remove = "python3-pyqt5"
ROS_BUILD_DEPENDS:append = " python3-pyqt6"

ROS_EXEC_DEPENDS:remove = "python3-pyqt5"
ROS_EXEC_DEPENDS:append = " python3-pyqt6"

inherit python3targetconfig

DEPENDS += "sip-native python3-pyqt-builder-native"
