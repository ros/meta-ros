# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-vesc_interface-work-around-missing-return-value-in-V.patch"
