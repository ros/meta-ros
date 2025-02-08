# Copyright (c) 2024 Wind River Systems, Inc.

# ERROR: gz-dartsim-vendor-0.1.0-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package gz-dartsim-vendor contains symlink .so
inherit ros_insane_dev_so

# DART is BSD-2-Clause but the vendor package is Apache-2.0
LICENSE = "Apache-2.0"

ROS_BUILD_DEPENDS = "dartsim"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-system-dartsim.patch"

# do_install:append:class-target () {
#     sed -i -e "s,--sysroot=${STAGING_DIR_TARGET},,g" ${D}${ros_libdir}/pkgconfig/dart.pc
#     sed -i -e "s,-fdebug-prefix-map=${STAGING_DIR_HOST}=,,g" ${D}${ros_libdir}/pkgconfig/dart.pc
#     sed -i -e "s,-fmacro-prefix-map=${STAGING_DIR_HOST}=,,g" ${D}${ros_libdir}/pkgconfig/dart.pc
#     sed -i -e "s,-fdebug-prefix-map=${STAGING_DIR_NATIVE}=,,g" ${D}${ros_libdir}/pkgconfig/dart.pc
#     sed -i -e "s, -fmacro-prefix-map=${S}=${TARGET_DBGSRC_DIR},,g" ${D}${ros_libdir}/pkgconfig/dart.pc
#     sed -i -e "s, -fdebug-prefix-map=${S}=${TARGET_DBGSRC_DIR},,g" ${D}${ros_libdir}/pkgconfig/dart.pc
#     sed -i -e "s, -fmacro-prefix-map=${B}=${TARGET_DBGSRC_DIR},,g" ${D}${ros_libdir}/pkgconfig/dart.pc
#     sed -i -e "s, -fdebug-prefix-map=${B}=${TARGET_DBGSRC_DIR},,g" ${D}${ros_libdir}/pkgconfig/dart.pc
#     sed -i -e "s, -fdebug-prefix-map=${STAGING_DIR_HOST}=,,g" ${D}${ros_libdir}/pkgconfig/dart.pc
#     sed -i -e "s, -fmacro-prefix-map=${STAGING_DIR_HOST}=,,g" ${D}${ros_libdir}/pkgconfig/dart.pc
#     sed -i -e "s, -fdebug-prefix-map=${STAGING_DIR_NATIVE}=,,g" ${D}${ros_libdir}/pkgconfig/dart.pc
# }

inherit pkgconfig
