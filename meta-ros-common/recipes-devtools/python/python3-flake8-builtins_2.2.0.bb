DESCRIPTION = "Check for python builtins being used as variables or parameters"
HOMEPAGE = "https://github.com/gforcada/flake8-builtins"
SECTION = "devel/python"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PYPI_PACKAGE = "flake8_builtins"
SRC_URI[sha256sum] = "392d5af3a0720c5a863aa93dc47f48c879081345a143fe9f20d995fe9ff5686a"

inherit pypi

BBCLASSEXTEND = "native"
