DESCRIPTION = "A simple Python wrapper for Assimp using ctypes to access the library."
HOMEPAGE = "https://github.com/assimp/assimp"
SECTION = "devel/python"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=4f642f6b5995ade4c8b11f8b200da0ca"

SRC_URI[md5sum] = "682f1583e7d8e130fe70bf754721dcb5"
SRC_URI[sha256sum] = "266bd4be170d46065b8c2ad0f5396dad10938a6bbf9a566c4e4d56456e33aa6a"

inherit pypi

PACKAGES += "${PN}-examples"
FILES_${PN}-examples += "${datadir}/examples/${PYPI_PACKAGE}/"
FILES_${PN} += "${datadir}/${PYPI_PACKAGE}/README.rst"
