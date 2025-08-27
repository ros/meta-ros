SUMMARY = "A flake8 extension that checks for blind except: statements"
HOMEPAGE = "https://github.com/elijahandrews/flake8-blind-except"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=87cef38b7e9e12f37eb14bc04d53394a"

SRC_URI[sha256sum] = "f25a575a9dcb3eeb3c760bf9c22db60b8b5a23120224ed1faa9a43f75dd7dd16"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-core python3-pep8"

PYPI_PACKAGE = "flake8-blind-except"
