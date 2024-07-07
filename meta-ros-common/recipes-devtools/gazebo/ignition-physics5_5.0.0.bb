# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://LICENSE;md5=2e9f68f022747514564aa13818fcb7c6 \
                    file://tpe/lib/src/aabb_tree/LICENSE;md5=fd0ac4e17e55ad320e9429c05b5c23c7"

SRC_URI = "git://github.com/gazebosim/gz-physics.git;protocol=https;branch=ign-physics5"

SRCREV = "ba3eb2c7f32660eef82e27f24401783f80cfcf2b"

S = "${WORKDIR}/git"

DEPENDS += " \
    ignition-cmake2 \
    ignition-math6 \
    ignition-common4 \
    ignition-transport11 \
    ignition-rendering6 \
    ignition-msgs8 \
    protobuf \
    sdformat \
"

inherit cmake
