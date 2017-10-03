DESCRIPTION = "ECDSA cryptographic signature library"
HOMEPAGE = "https://github.com/warner/python-ecdsa"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCNAME = "ecdsa"

SRC_URI = "https://pypi.python.org/packages/source/e/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"

SRC_URI[md5sum] = "1f60eda9cb5c46722856db41a3ae6670"
SRC_URI[sha256sum] = "64cf1ee26d1cde3c73c6d7d107f835fed7c6a2904aef9eac223d57ad800c43fa"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS += " \
        python-pip \
        python-pbr \
        "

# RDEPENDS_default:
RDEPENDS_${PN} += " \
        python-pbr \
        "