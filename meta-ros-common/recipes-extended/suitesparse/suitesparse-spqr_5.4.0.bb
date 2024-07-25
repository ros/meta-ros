# Copyright (c) 2019 LG Electronics, Inc.

require suitesparse-5.4.0.inc

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM += "file://Doc/License.txt;md5=1c0c48edf24526b3cda72ce1a8a20b1d"

DEPENDS = " \
    suitesparse-config \
    suitesparse-amd \
    suitesparse-colamd \
    suitesparse-cholmod \
    lapack \
"

S = "${WORKDIR}/SuiteSparse/SPQR"

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
# WARNING: suitesparse-spqr-5.4.0-r0 do_package_qa: QA Issue: package suitesparse-spqr contains bad RPATH /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-spqr/5.4.0-r0/image/usr/lib in file /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-spqr/5.4.0-r0/packages-split/suitesparse-spqr/usr/lib/libspqr.so.2.0.9 [rpaths]
do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}
