# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-rosserial_server-fix-build-with-boost-1.70.0.patch \
    file://0001-rosserial_server-udp_stream-fix-build-with-boost-1.7.patch \
"
