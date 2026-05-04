# Copyright (c) 2025 Wind River Systems, Inc.

LICENSE = "Apache-2.0 & BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://test/gtest_vendor/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a"

SRC_URI = "git://github.com/gazebosim/gz-launch.git;protocol=https;branch=gz-launch9"

SRCREV = "b6244f99f4ace4ccc1e10786128fa82810c11833"


DEPENDS = " \
    gz-cmake \
    gz-common \
    gz-gui \
    gz-math \
    gz-msgs \
    gz-plugin \
    gz-sim \
    gz-tools \
    gz-transport \
    libtinyxml2 \
    libwebsockets \
    libyaml \
    protobuf \
    protobuf-native \
    util-linux-libuuid \
"

# This resolves the following error:
#   To use a cross-compiled Qt, please set the QT_HOST_PATH cache variable to
#   the location of your host Qt installation.
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt6-layer', 'qt6-cmake', '', d)}

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

inherit cmake pkgconfig

FILES:${PN} += " \
    ${libdir}/gz/launch9/gz-launch \
    ${libdir}/gz-launch-9/plugins/* \
    ${libdir}/ruby/gz/* \
    ${datadir}/gz/* \
"
