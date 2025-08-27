SUMMARY = "Flake8 lint for quotes."
HOMEPAGE = "http://github.com/zheller/flake8-quotes/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=838c366f69b72c5df05c96dff79b35f2"

SRC_URI[sha256sum] = "aad8492fb710a2d3eabe68c5f86a1428de650c8484127e14c43d0504ba30276c"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-flake8 python3-setuptools"

RDEPENDS:${PN} += "python3-core python3-flake8 python3-pycodestyle"

PYPI_PACKAGE = "flake8-quotes"
