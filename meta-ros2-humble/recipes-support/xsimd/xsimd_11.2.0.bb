LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fdd4d7dc8bdd9ae7181dd0bca68007a2"

SRC_URI = "git://github.com/xtensor-stack/xsimd.git;protocol=https;branch=master"

PV = "11.2.0+git${SRCPV}"
SRCREV = "7bc4dd00c0df2c235e07bc3a2154159e2040e9f5"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS = "xtl"

