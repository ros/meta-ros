SUMMARY = "catkin package library"
DESCRIPTION = "Standalone Python library for the catkin build system"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=9;endline=9;md5=e910b35b0ef4e1f665b9a75d6afb7709"
PYPI_PACKAGE = "catkin_pkg"

DEPENDS = "python3-pyparsing"

SRC_URI[sha256sum] = "df1cb6879a3a772e770a100a6613ce8fc508b4855e5b2790106ddad4a8beb43c"

inherit setuptools3 ptest-python-pytest
inherit pypi

RDEPENDS:${PN} = "python3-dateutil python3-docutils python3-pyparsing python3-unixadmin"
RDEPENDS:${PN}:class-native = ""

PTEST_PYTEST_DIR = "test"

BBCLASSEXTEND = "native nativesdk"
