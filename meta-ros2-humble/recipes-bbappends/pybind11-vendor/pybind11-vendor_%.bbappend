# Copyright (c) 2020-2021 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics, S.L.

DEPENDS += "python3-pybind11"
RDEPENDS:${PN} += "python3-pybind11"
ALLOW_EMPTY:${PN} = "1"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-rolling-pybind11-vendor-don-t-build-pybind11-use-pla.patch"
