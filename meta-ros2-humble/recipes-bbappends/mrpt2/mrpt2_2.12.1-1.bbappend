# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://disable-host-system-dirs.patch \
            file://enable-linking-octomap.patch \
            file://0001-mrpt2-gui-pthread.patch \
            file://0002-fix-debian-bug-unambiguous-tracking.patch \
            file://add-cmake-toolchain-file-to-nanoflann.patch \
"
# Make this conditional on meta-qt5, because otherwise builds without
# meta-qt5 give the error "Could not inherit file classes/cmake_qt5.bbclass"
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', 'cmake_qt5', '', d)}

# CMake Error: TRY_RUN() invoked in cross-compiling mode, please set the following cache variables appropriately:
#   HAS_LTO_EXITCODE (advanced)
#   HAS_LTO_EXITCODE__TRYRUN_OUTPUT (advanced)
EXTRA_OECMAKE += "-DHAS_LTO_EXITCODE=1 -DHAS_LTO_EXITCODE__TRYRUN_OUTPUT=0"

EXTRA_OECMAKE += "-DCMAKE_CXX_IMPLICIT_INCLUDE_DIRECTORIES:PATH='${STAGING_INCDIR}'"

# Otherwise it tries to build own version with ExternalProject_Add and fails
# ninja: error: 'lib/liboctomath.a', needed by 'lib/libmrpt-maps.so.2.0.4', missing and no known rule to make it
ROS_BUILD_DEPENDS += " \
    octomap \
"

inherit pkgconfig
inherit ros_ament_cmake

ROS_BUILDTOOL_DEPENDS += " \
    ament-package-native \
"

ROS_BUILD_DEPENDS += " \
    ament-cmake-libraries \
    ament-cmake-export-definitions \
    ament-cmake-export-include-directories \
    ament-cmake-export-interfaces \
    ament-cmake-export-libraries \
    ament-cmake-export-link-flags \
    ament-cmake-export-targets \
    ament-cmake-gen-version-h \
    ament-cmake-python \
    ament-cmake-target-dependencies \
    ament-cmake-include-directories \
    ament-cmake-test \
    ament-cmake-version \
    nanogui \
    rosidl-adapter \
"

FILES_${PN} += "${datadir}/mrpt* ${datadir}/metainfo/* ${datadir}/mime/packages/*"
