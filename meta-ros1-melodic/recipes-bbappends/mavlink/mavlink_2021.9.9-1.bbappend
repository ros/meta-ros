# Copyright (c) 2021 LG Electronics, Inc.

ROS_BUILD_DEPENDS += " \
    ${PYTHON_PN}-future-native \
    ${PYTHON_PN}-lxml-native \
"

inherit pythonnative

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-remove-ardupilotmega-message-definiti.patch"
