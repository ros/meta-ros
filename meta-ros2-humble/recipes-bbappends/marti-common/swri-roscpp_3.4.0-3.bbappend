# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2022 Wind River Systems, Inc.

FILES:${PN} += "${prefix}/launch"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Fix-warnings-and-deprecations-in-galactic.patch"
