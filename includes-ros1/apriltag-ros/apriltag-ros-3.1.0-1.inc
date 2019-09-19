# Copyright (c) 2019 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/apriltag-ros:"
SRC_URI += " \
    file://fix.apriltag.include.flag.patch \
"
