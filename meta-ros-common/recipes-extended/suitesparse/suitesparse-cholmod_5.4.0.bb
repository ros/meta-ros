# Copyright (c) 2019 LG Electronics, Inc.

require suitesparse-5.4.0.inc

LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM += "file://Doc/License.txt;md5=5d8c39b6ee2eb7c9e0e226a333be30cc"

DEPENDS = " \
    suitesparse-config \
    suitesparse-amd \
    suitesparse-colamd \
    suitesparse-ccolamd \
    suitesparse-camd \
    suitesparse-metis \
    lapack \
    openblas \
"

S = "${WORKDIR}/SuiteSparse/CHOLMOD"

EXTRA_OEMAKE = "CC='${CC}' BLAS='-lopenblas -lblas'"

do_compile() {
    # build only the library, not the demo
    oe_runmake library
}

do_install() {
    oe_runmake install INSTALL=${D}${prefix}
}
