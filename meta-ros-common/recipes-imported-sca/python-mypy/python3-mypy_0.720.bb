SUMMARY = "Optional static typing for Python 3 and 2 (PEP 484)"
HOMEPAGE = "https://github.com/python/mypy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8d438618dacdddfdf08836bfe5e4b8a7"

RDEPENDS:${PN} = " \
    ${PYTHON_PN}-mypy-extensions \
    ${PYTHON_PN}-typed-ast \
    ${PYTHON_PN}-typing-extensions \
"

PYPI_PACKAGE = "mypy"

inherit pypi
inherit setuptools3

SRC_URI[md5sum] = "ae3f2772193f0bfe0f7182993daef051"
SRC_URI[sha256sum] = "49925f9da7cee47eebf3420d7c0e00ec662ec6abb2780eb0a16260a7ba25f9c4"

BBCLASSEXTEND = "native"
