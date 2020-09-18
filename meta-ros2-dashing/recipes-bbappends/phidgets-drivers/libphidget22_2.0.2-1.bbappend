# Copyright (c) 2019-2020 LG Electronics, Inc.

# WARNING: libphidget22-2.0.1-1-r0 do_populate_lic: libphidget22: No generic license file exists for: LGPL-2 in any provider
# COPYING and COPYING.LESSER in libphidget22-1.4.20190605.tar.gz say GPL-3.0+ and LGPL-3.0+, source files have LGPL-3.0+
# headers only autotools files are GPL-3.0+
LICENSE = "LGPL-3.0+"

DEPENDS += "${PN}-upstream"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Use-libphidget22-from-libphidget22-upstream-and-norm.patch"
