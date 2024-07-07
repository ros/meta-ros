# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-sensors.git;protocol=https;branch=gz-sensors8"

SRCREV = "410a999f1e0e91bdcf81c6aff70fa3e95e369757"

S = "${WORKDIR}/git"

DEPENDS += " \
    cppcheck-native \
    doxygen-native \
    gz-cmake3 \
    gz-common5 \
    gz-math7 \
    gz-msgs10 \
    gz-rendering8 \
    gz-transport13 \
    protobuf \
    protobuf-native \
    sdformat \
"

inherit cmake

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

FILES:${PN} += "${datadir}/gz/gz-sensors8"
