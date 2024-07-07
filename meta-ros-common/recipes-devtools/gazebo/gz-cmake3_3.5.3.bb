# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-cmake.git;protocol=https;branch=gz-cmake3 \
           file://Fix-pkgconfig-install-dir.patch"

SRCREV = "ddd38ff196640024d6e054ff59cf5fea1ef01d73"

S = "${WORKDIR}/git"

inherit cmake

FILES:${PN} += "${datadir}/gz/gz-cmake3/*"

FILES:${PN}-dev += " \
    pkgconfig/gz-cmake3.pc \
    ${includedir} \
    ${datadir}/cmake/gz-cmake3/cmake3/ \
    ${datadir}/gz/gz-cmake3/ \
"

BBCLASSEXTEND = "native nativesdk"
