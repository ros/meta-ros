# Copyright (c) 2019 LG Electronics, Inc.

require suitesparse-5.4.0.inc

LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM += "file://Doc/License.txt;md5=c2a06105a6d78da59c0d0c5d0d9b1394"

S = "${WORKDIR}/SuiteSparse/CSparse"

EXTRA_OEMAKE = "CC='${CC}'"

do_compile() {
    # build only the library, not the demo
    oe_runmake library
}

do_install() {
    install -D -m0644 ${B}/Lib/libcsparse.a ${D}${libdir}/libcsparse.a
}
