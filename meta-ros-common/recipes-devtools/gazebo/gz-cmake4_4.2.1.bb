# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-cmake.git;protocol=https;branch=gz-cmake4 \
           file://Fix-pkgconfig-install-dir.patch"

SRCREV = "7ca9fe32d4bfa895496b2ac7f474653d005f16eb"

inherit cmake

FILES:${PN} += "${datadir}/gz/gz-cmake4/*"

FILES:${PN}-dev += " \
    pkgconfig/gz-cmake4.pc \
    ${includedir} \
    ${datadir}/cmake/gz-cmake4/cmake4/ \
    ${datadir}/gz/gz-cmake4/ \
"

BBCLASSEXTEND = "native nativesdk"
