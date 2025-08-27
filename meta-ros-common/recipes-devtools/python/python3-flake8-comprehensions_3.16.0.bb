SUMMARY = "A flake8 plugin to help you write better list/set/dict comprehensions."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dd54c94e040946267bc2300dbc7d7e6d"

SRC_URI[sha256sum] = "9cbf789905a8f03f9d350fb82b17b264d9a16c7ce3542b2a7b871ef568cafabe"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "python3-flake8"

PYPI_PACKAGE = "flake8_comprehensions"
