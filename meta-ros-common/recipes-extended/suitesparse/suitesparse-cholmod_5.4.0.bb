# Copyright (c) 2019 LG Electronics, Inc.

require suitesparse-5.4.0.inc

LICENSE = "LGPL-2.1-or-later"
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

EXTRA_OEMAKE = "CC='${CC}' BLAS='-lblas'"

do_compile() {
    # build only the library, not the demo
    oe_runmake library
}

do_install() {
    oe_runmake install INSTALL=${D}${prefix}
}

DEPENDS:append:class-target = " chrpath-replacement-native"
# For some reason ends with bad RPATH
# WARNING: suitesparse-cholmod-5.4.0-r0 do_package_qa: QA Issue: package suitesparse-cholmod contains bad RPATH /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-cholmod/5.4.0-r0/image/usr/lib in file /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-cholmod/5.4.0-r0/packages-split/suitesparse-cholmod/usr/lib/libcholmod.so.3.0.13 [rpaths]
do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}
