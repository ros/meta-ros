LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=a131b7bed5a9df7a654b4bbc3dc781c8"

SRC_URI = "gitsm://github.com/tbeu/matio.git;protocol=https;branch=master"

PV = "1.5.26+git${SRCPV}"
SRCREV = "32fe60952ca05dd3320e92e428a9da38752e6d50"

S = "${WORKDIR}/git"

DEPENDS = "zlib hdf5-native"

RDEPENDS:${PN} = "hdf5"

inherit cmake
