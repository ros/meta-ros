# Copyright (c) 2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://disable-compiler-warnings.patch \
            file://add-libcamera-cmake.patch \
            file://libcamera-0.8-api-updates.patch"

inherit pkgconfig
