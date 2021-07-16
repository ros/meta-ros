# Copyright (c) 2019 LG Electronics, Inc.

require suitesparse-5.4.0.inc

LICENSE = "PD"
LIC_FILES_CHKSUM += "file://README.txt;md5=9da0dd2832f2ab6d304cae1d28eecc11"

S = "${WORKDIR}/SuiteSparse/SuiteSparse_config"

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
# WARNING: suitesparse-config-5.4.0-r0 do_package_qa: QA Issue: package suitesparse-config contains bad RPATH /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-config/5.4.0-r0/image/usr/lib in file /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-config/5.4.0-r0/packages-split/suitesparse-config/usr/lib/libsuitesparseconfig.so.5.4.0 [rpaths]
do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}
