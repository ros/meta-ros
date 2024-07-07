# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

require suitesparse-7.7.0.inc

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM += "file://Doc/License.txt;md5=9207c2ee27101a898ff5fc1c60636cee"

DEPENDS = " \
    suitesparse-config \
"

S = "${WORKDIR}/git/CAMD"

inherit cmake pkgconfig

DEPENDS:append:class-target = " chrpath-replacement-native"
# For some reason ends with bad RPATH
# WARNING: suitesparse-camd-2.4.6-r0 do_package_qa: QA Issue: package suitesparse-camd contains bad RPATH /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-camd/2.4.6-r0/image/usr/lib in file /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-camd/2.4.6-r0/packages-split/suitesparse-camd/usr/lib/libcamd.so.2.4.6 [rpaths]
do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}
