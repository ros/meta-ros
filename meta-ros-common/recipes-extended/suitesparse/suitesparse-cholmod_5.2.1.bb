# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

require suitesparse-7.7.0.inc

LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM += "file://Doc/License.txt;md5=56def293641dc4b931815801e87b5aea"

DEPENDS = " \
    suitesparse-config \
    suitesparse-amd \
    suitesparse-colamd \
    suitesparse-ccolamd \
    suitesparse-camd \
    lapack \
    openblas \
"

S = "${WORKDIR}/git/CHOLMOD"

inherit cmake pkgconfig

EXTRA_OECMAKE = "-DSUITESPARSE_USE_64BIT_BLAS=ON -DBLA_PREFER_PKGCONFIG=ON"

DEPENDS:append:class-target = " chrpath-replacement-native"
# For some reason ends with bad RPATH
# WARNING: suitesparse-cholmod-5.4.0-r0 do_package_qa: QA Issue: package suitesparse-cholmod contains bad RPATH /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-cholmod/5.4.0-r0/image/usr/lib in file /jenkins/mjansa/build-ros/ros2-dashing-master/tmp-glibc/work/core2-32-oe-linux/suitesparse-cholmod/5.4.0-r0/packages-split/suitesparse-cholmod/usr/lib/libcholmod.so.3.0.13 [rpaths]
# QA Issue: File /usr/lib/pkgconfig/CHOLMOD.pc in package suitesparse-cholmod-dev contains reference to TMPDIR [buildpaths]
#QA Issue: File /usr/lib/cmake/CHOLMOD/CHOLMODTargets.cmake in package suitesparse-cholmod-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}/usr/lib/pkgconfig/CHOLMOD.pc
    sed -i -e "s#${RECIPE_SYSROOT}/usr/lib/##g" ${D}/usr/lib/cmake/CHOLMOD/CHOLMODTargets.cmake
}
