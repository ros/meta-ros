# Copyright (c) 2019 LG Electronics, Inc.

DESCRIPTION = "pydocstyle is a static analysis tool for checking compliance with Python docstring conventions"
HOMEPAGE = "https://github.com/PyCQA/pydocstyle"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[sha256sum] = "7ce43f0c0ac87b07494eb9c0b462c0b73e6ff276807f204d6b53edc72b7e44e1"

inherit python_poetry_core pypi

BBCLASSEXTEND = "native"
