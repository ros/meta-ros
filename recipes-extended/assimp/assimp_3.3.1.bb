DESCRIPTION = "Open Asset Import Library"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4cd8c0aedc7a0623476669377d7eeda8"

DEPENDS = "boost"

SRC_URI = "https://github.com/${PN}/${PN}/archive/v${PV}.tar.gz;downloadfilename=${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "fc57b024e80ebb13301bd0983826cad3"
SRC_URI[sha256sum] = "d385c3f90876241343f09e45f4e5033a6a05861b971c63d1f6d512371ffdc7bf"

SRC_URI += "file://0001-Use-Assimp-namespace-to-fix-build-for-big-endian-arc.patch"

S = "${WORKDIR}/${PN}-${PV}"

inherit cmake

FILES_${PN}-dev += "${libdir}/cmake/assimp-3.3/*.cmake"
