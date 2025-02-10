# Copyright (c) 2023-2025 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

SRC_URI += "file://adding-sip5-integration.patch"

inherit python3targetconfig

DEPENDS += "sip-native python3-pyqt5-native"
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
