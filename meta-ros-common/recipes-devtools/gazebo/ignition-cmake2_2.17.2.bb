# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-cmake.git;protocol=https;branch=ign-cmake2"

SRCREV = "5441bc74997de9fe6b23e9d844251b6897e1f197"

S = "${WORKDIR}/git"

FILES:${PN} += "${datadir}/ignition/ignition-cmake2/*"
inherit cmake

FILES:${PN}-dev += " \
    pkgconfig/ignition-cmake2.pc \
    ${includedir} \
    ${datadir}/cmake/ignition-cmake2/cmake2/ \
    ${datadir}/ignition/ignition-cmake2/ \
"

BBCLASSEXTEND = "native nativesdk"
