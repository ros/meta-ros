# Copyright (c) 2020-2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Fix-build-with-gcc-10.patch"
SRC_URI += "file://0001-Fix-build-with-gcc-11.patch"
