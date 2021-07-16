# Copyright (c) 2019-2021 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-pyyaml-native \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fix-Boost_VERSION-conditional-to-work.patch"

SRC_URI += "file://0001-Fix-build-with-boost-1.73.0.patch"

SRC_URI:append:class-native = " file://0001-Revert-declare-pthread-as-a-dependency-fix-135.patch"
