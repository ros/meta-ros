# Copyright (c) 2022-2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://add-bullet-dependency.patch"

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package moveit-planners-chomp contains symlink .so '/usr/lib/libmoveit_chomp_interface.so' [dev-so]
FILES:${PN}-dev += "${libdir}/libmoveit_chomp_interface.so"
