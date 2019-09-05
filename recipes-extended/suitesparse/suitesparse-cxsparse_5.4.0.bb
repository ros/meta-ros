# Copyright (c) 2019 LG Electronics, Inc.

require suitesparse-5.4.0.inc

LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM += "file://Doc/License.txt;md5=0e5191611fba4aac850756c5d598ff23"

DEPENDS = "suitesparse-config"

S = "${WORKDIR}/SuiteSparse/CXSparse"

EXTRA_OEMAKE = "CC='${CC}'"

do_compile() {
    # build only the library, not the demo
    oe_runmake library
}

do_install() {
    oe_runmake install INSTALL=${D}${prefix}
    ln -snf . ${D}${includedir}/suitesparse
}
