# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

require suitesparse-7.7.0.inc

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM += "file://Doc/License.txt;md5=93997dd55f2c98be2351a1e84f528ecc"

DEPENDS = " \
    suitesparse-config \
"

S = "${WORKDIR}/git/COLAMD"

inherit cmake pkgconfig

DEPENDS:append:class-target = " chrpath-replacement-native"
# For some reason ends with bad RPATH
# WARNING: suitesparse-colamd-2.9.6-r0 do_package_qa: QA Issue: package suitesparse-colamd contains bad RPATH /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-colamd/2.9.6-r0/image/usr/lib in file /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-colamd/2.9.6-r0/packages-split/suitesparse-colamd/usr/lib/libcolamd.so.2.9.6 [rpaths]
do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}
