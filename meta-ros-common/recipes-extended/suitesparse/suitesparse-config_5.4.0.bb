# Copyright (c) 2019 LG Electronics, Inc.

require suitesparse-5.4.0.inc

LICENSE = "PD"
LIC_FILES_CHKSUM += "file://README.txt;md5=9da0dd2832f2ab6d304cae1d28eecc11"

S = "${WORKDIR}/SuiteSparse/SuiteSparse_config"

EXTRA_OEMAKE = "CC='${CC}'"

do_compile() {
    # build only the library, not the demo
    oe_runmake library
}

do_install() {
    oe_runmake install INSTALL=${D}${prefix}
}
