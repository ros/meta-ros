# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Change-name-of-namespace-from-hardware_interface-to-.patch \
    file://0002-Modified-GimbalCmd.msg-and-delete-moving_average_fil.patch \
"
