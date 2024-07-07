# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

require suitesparse-7.7.0.inc

LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM += "file://Doc/License.txt;md5=c2a06105a6d78da59c0d0c5d0d9b1394"

S = "${WORKDIR}/git/CSparse"

inherit cmake pkgconfig

do_install() {
    install -D -m0644 ${B}/libcsparse.a ${D}${libdir}/libcsparse.a
    install -D -m0644 ${B}/libcsparse.so.4.3.2 ${D}${libdir}/libcsparse.so.4.3.2
    ln -sf libcsparse.so.4.3.2 ${D}${libdir}/libcsparse.so.4
    ln -sf libcsparse.so.4 ${D}${libdir}/libcsparse.so
}
