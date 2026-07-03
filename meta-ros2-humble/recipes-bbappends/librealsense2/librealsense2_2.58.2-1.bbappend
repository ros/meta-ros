# Copyright (c) 2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://fixed-compile-error-uint64t.patch"

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package librealsense2 contains symlink .so '/usr/lib/librealsense2.so' [dev-so]
FILES:${PN}-dev += "${libdir}/librealsense2.so"
