# Copyright (c) 2019 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/apriltag:"
SRC_URI += " \
    file://fix.cflags.in.pkg-config.patch \
"
