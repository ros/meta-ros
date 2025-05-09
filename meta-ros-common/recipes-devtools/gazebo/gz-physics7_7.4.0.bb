# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://tpe/lib/src/aabb_tree/LICENSE;md5=fd0ac4e17e55ad320e9429c05b5c23c7"

SRC_URI = "git://github.com/gazebosim/gz-physics.git;protocol=https;branch=gz-physics7"

SRCREV = "550c6b14e24bbf81087c5c03ed3b6a3e17e18cca"

S = "${WORKDIR}/git"

DEPENDS += " \
    gz-cmake3 \
    gz-common5 \
    gz-dartsim-vendor \
    gz-math7 \
    gz-msgs10 \
    gz-rendering8 \
    gz-transport13 \
    protobuf \
    sdformat \
    bullet \
    cppcheck-native \
    google-benchmark-vendor \
"

EXTRA_OECMAKE += " -DBUILD_TESTING=OFF"

inherit cmake

FILES:${PN} += " \
    ${libdir}/gz-physics-7/engine-plugins/lib*${SOLIBS} \
"

FILES:${PN}-dev += " \
    ${libdir}/gz-physics-7/engine-plugins/lib*${SOLIBSDEV} \
"
