# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/sdformat.git;protocol=https;branch=sdf15"

SRCREV = "cc524e7ebea952652aea3b03a95f13dc6416c563"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

DEPENDS = " \
    gz-cmake-vendor \
    gz-math-vendor \
    gz-tools-vendor \
    gz-utils-vendor \
    libtinyxml2 \
    python3-pybind11 \
    python3-psutil-native \
    ruby-native \
    urdfdom \
"

FILES:${PN} += " \
    ${libdir}/ruby/gz \
    ${datadir}/gz \
    ${datadir}/sdformat15/* \
"

do_install:append() {
    rm ${D}/usr/lib/python/sdformat15.cpython-312-x86_64-linux-gnu.so
    rm -r ${D}/usr/lib/python
}
