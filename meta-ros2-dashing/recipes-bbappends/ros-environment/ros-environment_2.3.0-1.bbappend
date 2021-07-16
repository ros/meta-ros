# Copyright (c) 2019 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI:append = " \
    file://add-os-override.patch \
"
