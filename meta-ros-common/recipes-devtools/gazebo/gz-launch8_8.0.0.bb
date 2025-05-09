# Copyright (c) 2025 Wind River Systems, Inc.

LICENSE = "Apache-2.0 & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://test/gtest_vendor/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a"

SRC_URI = "git://github.com/gazebosim/gz-launch.git;protocol=https;branch=gz-launch8"

SRCREV = "dc94c9a7d1e4112962b7095ebce3e3cf9ed400bc"

S = "${WORKDIR}/git"

DEPENDS = " \
    gz-cmake4 \
    gz-common6 \
    gz-gui9 \
    gz-math8 \
    gz-msgs11 \
    gz-plugin3 \
    gz-sim9 \
    gz-tools2 \
    gz-transport14 \
    libtinyxml2 \
    libwebsockets \
    libyaml \
    protobuf \
    protobuf-native \
    util-linux-libuuid \
"

# CMake Warning at TOPDIR/tmp/work/core2-64-oe-linux/gz-launch8/8.0.0/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', 'cmake_qt5', '', d)}

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

inherit cmake pkgconfig

FILES:${PN} += " \
    ${libdir}/gz/launch8/gz-launch \
    ${libdir}/gz-launch-8/plugins/* \
    ${libdir}/ruby/gz/* \
    ${datadir}/gz/* \
"
