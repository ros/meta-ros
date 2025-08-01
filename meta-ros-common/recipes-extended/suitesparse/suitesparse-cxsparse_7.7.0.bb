# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

require suitesparse-7.7.0.inc

LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM += "file://Doc/License.txt;md5=0e5191611fba4aac850756c5d598ff23"

DEPENDS = "suitesparse-config"

S = "${UNPACKDIR}/${BB_GIT_DEFAULT_DESTSUFFIX}/CXSparse"

inherit cmake pkgconfig

DEPENDS:append:class-target = " chrpath-replacement-native"
# For some reason ends with bad RPATH
# WARNING: suitesparse-cxsparse-5.4.0-r0 do_package_qa: QA Issue: package suitesparse-cxsparse contains bad RPATH /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-cxsparse/5.4.0-r0/image/usr/lib in file /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-cxsparse/5.4.0-r0/packages-split/suitesparse-cxsparse/usr/lib/libcxsparse.so.3.2.0 [rpaths]
do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}
