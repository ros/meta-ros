DESCRIPTION = "A flake8 plugin to help you write better list/set/dict comprehensions."
HOMEPAGE = "https://github.com/adamchainz/flake8-comprehensions"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dd54c94e040946267bc2300dbc7d7e6d"

PYPI_PACKAGE = "flake8_comprehensions"
SRC_URI[sha256sum] = "81768c61bfc064e1a06222df08a2580d97de10cb388694becaf987c331c6c0cf"

inherit pypi

BBCLASSEXTEND = "native"
