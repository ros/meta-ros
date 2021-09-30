# Copyright (c) 2020-2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-Fix-build-with-gpsd-3.20.patch \
    file://0001-Fix-build-with-gpsd-3.21.patch \
"

inherit pkgconfig
