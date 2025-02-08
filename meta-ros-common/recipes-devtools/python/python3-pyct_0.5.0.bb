SUMMARY = "Python package common tasks for users (e.g. copy examples, fetch data, ...)"
DESCRIPTION = "A utility package that includes pyct.cmd and pyct.build"
HOMEPAGE = "https://github.com/pyviz-dev/pyct"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=a5a58acaa3e8f6b6011f5a17eacc6e1e"

PYPI_PACKAGE = "pyct"

inherit pypi setuptools3

SRC_URI[sha256sum] = "dd9f4ac5cbd8e37c352c04036062d3c5f67efec76d404761ef16b0cbf26aa6a0"

BBCLASSEXTEND = "native nativesdk"
