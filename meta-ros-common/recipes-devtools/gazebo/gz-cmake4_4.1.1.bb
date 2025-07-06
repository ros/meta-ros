# Copyright (c) 2024 Wind River Systems, Inc.
SUMMARY = "CMake Modules for Gazebo Projects"
DESCRIPTION = "\
    gz-cmake provides a set of cmake modules that are used by the C++ based Gazebo projects. \
    These modules help to control the quality and consistency of the Gazebo projects build systems. \
    "
HOMEPAGE = "https://gazebosim.org/libs/cmake/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-cmake.git;protocol=https;branch=gz-cmake4 \
           file://Fix-pkgconfig-install-dir.patch"

SRCREV = "1c65374c074268ec93df72be4a2d21722920e62a"

inherit cmake

FILES:${PN} += "${datadir}/gz/gz-cmake4/*"

FILES:${PN}-dev += "\
    pkgconfig/gz-cmake4.pc \
    ${includedir} \
    ${datadir}/cmake/gz-cmake4/cmake4/ \
    ${datadir}/gz/gz-cmake4/ \
"

BBCLASSEXTEND = "native nativesdk"
