# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://tpe/lib/src/aabb_tree/LICENSE;md5=fd0ac4e17e55ad320e9429c05b5c23c7"

SRC_URI = "git://github.com/gazebosim/gz-physics.git;protocol=https;branch=gz-physics8"

SRCREV = "8e28e941d71c9214c89d14658cbf219ef324e0a7"

S = "${WORKDIR}/git"

DEPENDS += " \
    gz-cmake4 \
    gz-common6 \
    gz-dartsim-vendor \
    gz-math7 \
    gz-plugin3 \
    gz-utils3 \
    protobuf \
    sdformat \
    libeigen \
    bullet \
    cppcheck-native \
    google-benchmark-vendor \
"

EXTRA_OECMAKE += " -DBUILD_TESTING=OFF"

inherit cmake

FILES:${PN} += " \
    ${libdir}/gz-physics-8/engine-plugins/lib*${SOLIBS} \
"

FILES:${PN}-dev += " \
    ${libdir}/gz-physics-8/engine-plugins/lib*${SOLIBSDEV} \
"
