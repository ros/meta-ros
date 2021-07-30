# Copyright (c) 2019-2020 LG Electronics, Inc.

ROS_BUILD_DEPENDS:remove = "python-numpy"
ROS_BUILD_DEPENDS:remove = "python3-numpy"

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-numpy-native \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-add-OpenCV4-support-addresses-ros-perception-vision_.patch \
    file://0002-CMakeLists.txt-search-for-boost_python-Python3_VERSI.patch \
"
