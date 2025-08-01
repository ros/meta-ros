SUMMARY = "McCabe checker, plugin for flake8"
HOMEPAGE = "https://github.com/dreamhost/cliff"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a489dc62bacbdad3335c0f160a974f0f"

SRC_URI += " \
           file://0001-python-mccabe-remove-unnecessary-setup_requires-pyte.patch \
"

SRC_URI[sha256sum] = "dd8d182285a0fe56bace7f45b5e7d1a6ebcbf524e8f3bd87eb0f125271b8831f"

inherit pypi setuptools3

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-prettytable \
    ${PYTHON_PN}-cmd2 \
    ${PYTHON_PN}-pyparsing"

BBCLASSEXTEND = "native nativesdk"
