SUMMARY = "Flake8 plugin that warns about deprecated method calls"
HOMEPAGE = "https://github.com/gforcada/flake8-deprecated"
DESCRIPTION = "Flake8 plugin that warns about deprecated method calls"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI[sha256sum] = "84cdb63f735ba976d41b263eac6cbee65bfab211f8748725d4e9dd95017dd1a7"

inherit pypi python_hatchling

PYPI_PACKAGE = "flake8_deprecated"

BBCLASSEXTEND = "native nativesdk"
