# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://recognize-busybox-star.patch \
"
