SUMMARY = "Check for python builtins being used as variables or parameters"
HOMEPAGE = "https://github.com/gforcada/flake8-builtins"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "bab4d458de6b828634f789f84cb31aff2ab5f92cd37b4f3888ffa5e78cd9d373"

inherit pypi python_hatchling

PYPI_PACKAGE = "flake8_builtins"
RDEPENDS:${PN} = "python3-flake8"
