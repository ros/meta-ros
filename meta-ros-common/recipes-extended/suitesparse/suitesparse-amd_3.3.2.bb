# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

require suitesparse-7.7.0.inc

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM += "file://Doc/License.txt;md5=5ba3300acc9ddc20a56f6c843e2d5e13"

DEPENDS = " \
    suitesparse-config \
"

S = "${WORKDIR}/git/AMD"

inherit cmake pkgconfig

DEPENDS:append:class-target = " chrpath-replacement-native"
# For some reason ends with bad RPATH
# WARNING: suitesparse-amd-2.4.6-r0 do_package_qa: QA Issue: package suitesparse-amd contains bad RPATH /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-amd/2.4.6-r0/image/usr/lib in file /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-amd/2.4.6-r0/packages-split/suitesparse-amd/usr/lib/libamd.so.2.4.6 [rpaths]
do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}
