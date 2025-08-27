SUMMARY = "Flake8 and pylama plugin that checks the ordering of import statements."
HOMEPAGE = "https://github.com/PyCQA/flake8-import-order"
LICENSE = "LGPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=e6a600fd5e1d9cbde2d983680233ad02"

SRC_URI[sha256sum] = "133b3c55497631e4235074fc98a95078bba817832379f22a31f0ad2455bcb0b2"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-pycodestyle python3-setuptools"

RDEPENDS:${PN} += "python3-core python3-shell"

PYPI_PACKAGE = "flake8_import_order"
