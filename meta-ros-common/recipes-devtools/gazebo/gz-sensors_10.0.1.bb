# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-sensors.git;protocol=https;branch=gz-sensors10"

SRCREV = "18c09c56df1d7c26b902a2d4b5b5481ceffdca4d"


DEPENDS += " \
    cppcheck-native \
    doxygen-native \
    gz-cmake \
    gz-common \
    gz-math \
    gz-msgs \
    gz-rendering \
    gz-transport \
    protobuf \
    protobuf-native \
    sdformat \
"

inherit cmake

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

FILES:${PN} += "${datadir}/gz/gz-sensors10"
