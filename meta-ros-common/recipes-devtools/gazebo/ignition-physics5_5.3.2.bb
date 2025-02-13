# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://tpe/lib/src/aabb_tree/LICENSE;md5=fd0ac4e17e55ad320e9429c05b5c23c7"

SRC_URI = "git://github.com/gazebosim/gz-physics.git;protocol=https;branch=ign-physics5 \
           file://add-include-algorithm.patch"

SRCREV = "9faf6b55975031e249a0a4f3ee0fcfc4cc5c0c72"

S = "${WORKDIR}/git"

DEPENDS += " \
    bullet \
    google-benchmark \
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

EXTRA_OECMAKE += " -DBUILD_TESTING=OFF"

FILES:${PN} += " \
    ${libdir}/ign-physics-5/engine-plugins/lib*${SOLIBS} \
"

FILES:${PN}-dev += " \
    ${libdir}/ign-physics-5/engine-plugins/lib*${SOLIBSDEV} \
"
