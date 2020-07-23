# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-urdfdom_headers.pc.in-urdfdom_headers-config.cmake.i.patch \
"
