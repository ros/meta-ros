# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

require suitesparse-7.7.0.inc

LICENSE = "PD"
LIC_FILES_CHKSUM += "file://README.txt;md5=dabbb8fc940f88cfe4fde254fad9dd68"

S = "${WORKDIR}/git/SuiteSparse_config"

inherit cmake pkgconfig

DEPENDS = "openblas"

EXTRA_OECMAKE = "-DSUITESPARSE_USE_64BIT_BLAS=ON -DBLA_PREFER_PKGCONFIG=ON"

DEPENDS:append:class-target = " chrpath-replacement-native"
# For some reason ends with bad RPATH
# WARNING: suitesparse-config-5.4.0-r0 do_package_qa: QA Issue: package suitesparse-config contains bad RPATH /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-config/5.4.0-r0/image/usr/lib in file /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-config/5.4.0-r0/packages-split/suitesparse-config/usr/lib/libsuitesparseconfig.so.5.4.0 [rpaths]
do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}
