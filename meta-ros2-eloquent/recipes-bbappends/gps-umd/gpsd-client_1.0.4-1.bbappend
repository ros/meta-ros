# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-Fix-build-with-gpsd-3.21.patch \
    file://0002-Fix-build-with-gpsd-3.23.1.patch \
    file://0003-Be-a-bit-more-strict-when-checking-the-symbols-defin.patch \
"

inherit pkgconfig
