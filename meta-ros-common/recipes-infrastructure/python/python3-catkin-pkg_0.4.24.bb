SUMMARY = "catkin package library"
DESCRIPTION = "Standalone Python library for the catkin build system"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
PYPI_PACKAGE = "catkin_pkg"

DEPENDS = "python3-pyparsing"

SRC_URI[sha256sum] = "f26d22cc5d8cb54f681f13fec4d06637b4983d493aa054f8e69ba888d632c6b4"
SRC_URI += "file://0001-python_setup.py-fix-build-with-setuptools-v59.0.0-an.patch"

inherit setuptools3
inherit pypi

RDEPENDS:${PN} = "python3-dateutil python3-docutils python3-pyparsing python3-unixadmin"
RDEPENDS:${PN}:class-native = ""

BBCLASSEXTEND = "native nativesdk"
