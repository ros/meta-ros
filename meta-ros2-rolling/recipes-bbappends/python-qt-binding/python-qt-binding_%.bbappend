# Copyright (c) 2023-2024 Wind River Systems, Inc.

SRC_URI += "file://adding-sip5-integration.patch"

inherit python3targetconfig

DEPENDS += "sip-native python3-pyqt5-native"
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
