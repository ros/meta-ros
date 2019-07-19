# Copyright (c) 2019 LG Electronics, Inc.

DESCRIPTION = "pydocstyle is a static analysis tool for checking compliance with Python docstring conventions"
HOMEPAGE = "https://github.com/PyCQA/pydocstyle"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[md5sum] = "2be57712e2743d23949bafed957d8c86"
SRC_URI[sha256sum] = "49680b7ea8c18e911135167e9f6986a3829031b55f2c737e6d2c398df38aafb5"

# It's the default tar.gz for v3.0.0
PYPI_PACKAGE_EXT = "zip"

inherit pypi

BBCLASSEXTEND = "native"
