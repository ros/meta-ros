# Copyright (c) 2019 LG Electronics, Inc.

require suitesparse-5.4.0.inc

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM += "file://Doc/License.txt;md5=1e9c216df23255c2cc290676276a051c"

DEPENDS = " \
    suitesparse-config \
"


S = "${WORKDIR}/SuiteSparse/AMD"

EXTRA_OEMAKE = "CC='${CC}'"

do_compile() {
    # build only the library, not the demo
    oe_runmake library
}

do_install() {
    oe_runmake install INSTALL=${D}${prefix}
}

DEPENDS:append:class-target = " chrpath-replacement-native"
# For some reason ends with bad RPATH
# WARNING: suitesparse-amd-2.4.6-r0 do_package_qa: QA Issue: package suitesparse-amd contains bad RPATH /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-amd/2.4.6-r0/image/usr/lib in file /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-amd/2.4.6-r0/packages-split/suitesparse-amd/usr/lib/libamd.so.2.4.6 [rpaths]
do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}
