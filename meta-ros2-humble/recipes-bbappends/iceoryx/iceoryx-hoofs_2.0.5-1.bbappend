# Copyright (c) 2021 LG Electronics, Inc.

# libatomic is just one of the packages provided by gcc-runtime recipe
# but gcc-runtime recipe doesn't have libatomic in PROVIDES, so we cannot map
# libatomic in rosdep to libatomic (without adding libatomic to PROVIDES in gcc-runtime
# bbappend). And we cannot leave gcc-runtime in ROS_EXEC_DEPENDS, because
# gcc-runtime recipe doesn't have PN in PACKAGES (and we would still depend
# on do_package shlibs handling to add runtime dependency on actual package
# with libatomic library)
ROS_EXEC_DEPENDS:remove = "gcc-runtime"
# there is no native support for gcc-runtime, so also no libatomic, add it only for target builds
ROS_EXEC_DEPENDS:append-class-target = " libatomic"
# and also remove it from build time depends when buiding native rc-utils
DEPENDS:remove:class-native = "gcc-runtime-native gcc-runtime"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-IceoryxPackageHelper.cmake-change-DESTINATION_CONFIG.patch \
    file://0001-Fix-build-with-gcc-11.patch \
    file://0001-Revert-iox-713-document-the-restrictions-on-size-and.patch \
"
