# Copyright (c) 2021 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    python3-numpy-native \
    rosidl-adapter \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://fix-pybind11-cross-compile-suffix.patch"

INSANE_SKIP:${PN} += "already-stripped"
