# Copyright (c) 2021 LG Electronics, Inc.

DEPENDS += "python3-future-native python3-lxml-native"

inherit python3native

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-remove-ardupilotmega-message-definiti.patch"
