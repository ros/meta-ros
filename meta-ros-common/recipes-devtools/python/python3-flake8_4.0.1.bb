DESCRIPTION = "The modular source code checker: pep8, pyflakes and co"
HOMEPAGE = "https://github.com/dreamhost/cliff"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=75b26781f1adf1aa310bda6098937878"

SRC_URI[md5sum] = "53e42c4191a4348c87aa292b79854889"
SRC_URI[sha256sum] = "806e034dda44114815e23c16ef92f95c91e4c71100ff52813adf7132a6ad870d"

inherit setuptools3 pypi

RDEPENDS:${PN} += "${PYTHON_PN}-prettytable \
            ${PYTHON_PN}-cmd2 \
            ${PYTHON_PN}-pyparsing \
            ${PYTHON_PN}-mccabe \
            ${PYTHON_PN}-pep8 \
            ${PYTHON_PN}-pyflakes"

BBCLASSEXTEND = "native"
