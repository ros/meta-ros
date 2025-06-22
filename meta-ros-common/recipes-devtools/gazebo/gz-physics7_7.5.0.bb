# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://tpe/lib/src/aabb_tree/LICENSE;md5=fd0ac4e17e55ad320e9429c05b5c23c7"

SRC_URI = "git://github.com/gazebosim/gz-physics.git;protocol=https;branch=gz-physics7"

SRCREV = "966563e1a403e90bf9a9cbf642dd0f58809f4a36"


DEPENDS = " \
    gz-cmake3 \
    gz-common5 \
    gz-dartsim-vendor \
    gz-math7 \
    gz-plugin2 \
    gz-utils2 \
    sdformat \
    bullet \
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
