DESCRIPTION = "SSH2 protocol library"
HOMEPAGE = "https://github.com/paramiko/paramiko/"
SECTION = "devel/python"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fd0120fc2e9f841c73ac707a30389af5"

SRC_URI[md5sum] = "7e1203f5ffeb7d2bc2bffc4feb804216"
SRC_URI[sha256sum] = "3297ebd3cd072f573772f7c7426939a443c62c458d54bb632ff30fd6ecf96892"

inherit pypi

RDEPENDS:${PN} += "${PYTHON_PN}-pycrypto ${PYTHON_PN}-ecdsa"

BBCLASSEXTEND += "native"
