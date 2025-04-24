# Copyright (c) 2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " file://add-lanelet2.patch"

LICENSE = "BSD-3-Clause"
