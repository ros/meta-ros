# Copyright (c) 2025 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-codec-Use-a-format-string-to-log-exceptions.patch"
