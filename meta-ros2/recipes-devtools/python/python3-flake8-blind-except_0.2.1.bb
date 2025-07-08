SUMMARY = "Flake8 extension that checks for blind, catch-all except statements"
HOMEPAGE = "https://github.com/elijahandrews/flake8-blind-except"
DESCRIPTION = "Flake8 extension that checks for blind, catch-all except statements"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=87cef38b7e9e12f37eb14bc04d53394a"

PYPI_PACKAGE = "flake8-blind-except"

SRC_URI[sha256sum] = "f25a575a9dcb3eeb3c760bf9c22db60b8b5a23120224ed1faa9a43f75dd7dd16"

inherit pypi

S = "${UNPACKDIR}/flake8-blind-except-0.2.1"

BBCLASSEXTEND = "native nativesdk"
