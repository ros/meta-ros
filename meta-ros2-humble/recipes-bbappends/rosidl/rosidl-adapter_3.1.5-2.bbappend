# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-fix-libdir.patch"

EXTRA_OECMAKE += " -DPYTHON_INSTALL_DIR=${baselib}/${PYTHON_DIR}/site-packages"

ROS_BUILD_DEPENDS:remove = "ament-cmake"
ROS_BUILDTOOL_DEPENDS += "ament-cmake-native"
