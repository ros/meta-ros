# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-sensors.git;protocol=https;branch=gz-sensors9"

SRCREV = "aa520011672583c434f9e01706c6b45b57352dc8"


DEPENDS += " \
    cppcheck-native \
    doxygen-native \
    gz-cmake4 \
    gz-common6 \
    gz-math8 \
    gz-msgs11 \
    gz-rendering9 \
    gz-transport14 \
    protobuf \
    protobuf-native \
    sdformat \
"

inherit cmake

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

FILES:${PN} += "${datadir}/gz/gz-sensors9"
