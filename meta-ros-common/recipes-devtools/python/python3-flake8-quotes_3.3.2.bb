DESCRIPTION = "Flake8 extension for checking quotes in python"
HOMEPAGE = "https://github.com/zheller/flake8-quotes/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=838c366f69b72c5df05c96dff79b35f2"

PYPI_PACKAGE = "flake8-quotes"
SRC_URI[sha256sum] = "6e26892b632dacba517bf27219c459a8396dcfac0f5e8204904c5a4ba9b480e1"

inherit pypi

BBCLASSEXTEND = "native"
