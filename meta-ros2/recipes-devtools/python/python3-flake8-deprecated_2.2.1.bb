SUMMARY = "Flake8 plugin that warns about deprecated method calls"
HOMEPAGE = "https://github.com/gforcada/flake8-deprecated"
DESCRIPTION = "Flake8 plugin that warns about deprecated method calls"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PYPI_PACKAGE = "flake8_deprecated"

SRC_URI[sha256sum] = "ee96ca001d1ca0561fa8e46f23e2d2460b18a86696373cab644e102ae0ff2aa2"

inherit pypi

S = "${UNPACKDIR}/flake8_deprecated-2.2.1"

BBCLASSEXTEND = "native nativesdk"
