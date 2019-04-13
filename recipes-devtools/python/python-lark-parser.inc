DESCRIPTION = "Lark is a modern general-purpose parsing library for Python"
HOMEPAGE = "https://github.com/warner/python-ecdsa"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[md5sum] = "50c4091ede31b155c0c48814571f527e"
SRC_URI[sha256sum] = "f2d5ee2f90aa28d3f4034c30af7a0561a7e9860e911dba4f35faa440a302be1b"

inherit pypi

BBCLASSEXTEND = "native"
