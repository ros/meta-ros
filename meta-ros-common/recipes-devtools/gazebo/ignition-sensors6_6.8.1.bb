# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-sensors.git;protocol=https;branch=ign-sensors6"

SRCREV = "9b408698a74903c6e3c5eb5745567a0cddef2ef7"

S = "${WORKDIR}/git"

DEPENDS += " \
    ignition-cmake2 \
    ignition-common4 \
    ignition-math6 \
    ignition-msgs8 \
    ignition-rendering6 \
    ignition-transport11 \
    protobuf \
    protobuf-native \
    sdformat \
"

inherit cmake

EXTRA_OECMAKE += " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/protoc \
"

