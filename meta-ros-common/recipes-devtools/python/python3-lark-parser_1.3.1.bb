# Copyright (c) 2019 LG Electronics, Inc.

DESCRIPTION = "Lark is a modern general-purpose parsing library for Python"
HOMEPAGE = "https://github.com/lark-parser/lark"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ba5edf8d60cf416b5588b1e6f152fcef"

PYPI_PACKAGE_SDIST = "lark"

SRC_URI[sha256sum] = "b426a7a6d6d53189d318f2b6236ab5d6429eaf09259f1ca33eb716eed10d2905"

inherit pypi python_setuptools_build_meta

DEPENDS += "python3-setuptools-scm-native"

BBCLASSEXTEND = "native nativesdk"
