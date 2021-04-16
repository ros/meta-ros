# Copyright (c) 2021 LG Electronics, Inc.

# libatomic is just one of the packages provided by gcc-runtime recipe
# but gcc-runtime recipe doesn't have libatomic in PROVIDES, so we cannot map
# libatomic in rosdep to libatomic (without adding libatomic to PROVIDES in gcc-runtime
# bbappend). And we cannot leave gcc-runtime in ROS_EXEC_DEPENDS, because
# gcc-runtime recipe doesn't have PN in PACKAGES (and we would still depend
# on do_package shlibs handling to add runtime dependency on actual package
# with libatomic library)
ROS_EXEC_DEPENDS_remove = "gcc-runtime"
ROS_EXEC_DEPENDS += "libatomic"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-IceoryxPackageHelper.cmake-change-DESTINATION_CONFIG.patch"
