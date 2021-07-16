SUMMARY = "Extra features for standard library's cmd module"
HOMEPAGE = "http://packages.python.org/cmd2/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=60bc6842001870a418935bd84570b676"

SRC_URI[md5sum] = "eeb80d5c29715b4ac39ecc032842a25f"
SRC_URI[sha256sum] = "f518d30c641483c8d6c246afae6e4447f816f8300befc6a11c476eeb62a496e6"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-pyparsing \
    ${PYTHON_PN}-pyperclip \
    ${PYTHON_PN}-six \
    "

BBCLASSEXTEND = "native nativesdk"
