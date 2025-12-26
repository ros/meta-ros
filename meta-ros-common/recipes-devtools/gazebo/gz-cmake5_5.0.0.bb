# Copyright (c) 2024 Wind River Systems, Inc.
SUMMARY = "A set of CMake modules that are used by the C++-based Gazebo projects"
HOMEPAGE = "https://gazebosim.org/libs/cmake/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-cmake.git;protocol=https;branch=gz-cmake5 \
           file://Fix-pkgconfig-install-dir.patch"

SRCREV = "891a912f35ea050d5238f6ff0f952a5954eb7e23"

inherit cmake

FILES:${PN} += "${datadir}/gz/gz-cmake/*"

FILES:${PN}-dev += "\
    pkgconfig/gz-cmake5.pc \
    ${includedir} \
    ${datadir}/cmake/gz-cmake/cmake/ \
    ${datadir}/gz/gz-cmake/ \
"

BBCLASSEXTEND = "native nativesdk"
