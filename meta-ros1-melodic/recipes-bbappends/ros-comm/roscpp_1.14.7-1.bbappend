# Copyright (c) 2019-2020 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-pyyaml-native \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fix-Boost_VERSION-conditional-to-work.patch"

SRC_URI += "file://0001-Fix-build-with-boost-1.73.0.patch"
