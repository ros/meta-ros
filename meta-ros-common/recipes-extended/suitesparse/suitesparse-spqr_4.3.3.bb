# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

require suitesparse-7.7.0.inc

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM += "file://Doc/License.txt;md5=1c0c48edf24526b3cda72ce1a8a20b1d"

DEPENDS = " \
    suitesparse-config \
    suitesparse-amd \
    suitesparse-colamd \
    suitesparse-cholmod \
    lapack \
    openblas \
"

S = "${WORKDIR}/git/SPQR"

inherit cmake pkgconfig

EXTRA_OECMAKE = "-DSUITESPARSE_USE_64BIT_BLAS=ON -DBLA_PREFER_PKGCONFIG=ON"

DEPENDS:append:class-target = " chrpath-replacement-native"
# For some reason ends with bad RPATH
# WARNING: suitesparse-spqr-5.4.0-r0 do_package_qa: QA Issue: package suitesparse-spqr contains bad RPATH /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-spqr/5.4.0-r0/image/usr/lib in file /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-spqr/5.4.0-r0/packages-split/suitesparse-spqr/usr/lib/libspqr.so.2.0.9 [rpaths]
# QA Issue: File /usr/lib/cmake/SPQR/SPQRTargets.cmake
do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
    sed -i -e "s#${RECIPE_SYSROOT}/usr/lib/##g" ${D}/usr/lib/cmake/SPQR/SPQRTargets.cmake
}
