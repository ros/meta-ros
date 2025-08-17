# Copyright (c) 2024 Botronics

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-adapter-native \
    generate-parameter-library-py-native \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://disable-compiler-options.patch"
