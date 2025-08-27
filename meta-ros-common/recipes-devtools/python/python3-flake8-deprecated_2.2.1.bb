SUMMARY = "Warns about deprecated method calls"
HOMEPAGE = "https://github.com/gforcada/flake8-deprecated"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "ee96ca001d1ca0561fa8e46f23e2d2460b18a86696373cab644e102ae0ff2aa2"

inherit pypi python_hatchling

PYPI_PACKAGE = "flake8-deprecated"
RDEPENDS:${PN} = "python3-flake8"
