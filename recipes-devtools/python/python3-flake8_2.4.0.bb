DESCRIPTION = "The modular source code checker: pep8, pyflakes and co"
HOMEPAGE = "https://github.com/dreamhost/cliff"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7a76e57e683629e1ac2a49406169c2a3"

SRC_URI[md5sum] = "d413935bb21026c18aca82654114502f"
SRC_URI[sha256sum] = "d26a9d0252da9f831b8277b824961bb10b1f9d79f4752d32e4814b7bcd1e089b"

inherit setuptools3 pypi

RDEPENDS_${PN} += "${PYTHON_PN}-prettytable \
            ${PYTHON_PN}-cmd2 \
            ${PYTHON_PN}-pyparsing \
            ${PYTHON_PN}-mccabe \
            ${PYTHON_PN}-pep8 \
            ${PYTHON_PN}-pyflakes"
