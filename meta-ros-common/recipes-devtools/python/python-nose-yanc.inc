# Copyright (c) 2019-2021 LG Electronics, Inc.

DESCRIPTION = "YANC is color output plugin for nose that plays nicely with others"
HOMEPAGE = "https://github.com/0compute/yanc"
SECTION = "devel/python"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI[md5sum] = "e1c6630d9c7e1210975c8d23ca50700f"
SRC_URI[sha256sum] = "1cdd6e61942b44acf38cad3650a776853609e90d3318501c0544c39be65c657c"

PYPI_PACKAGE = "yanc"

inherit pypi

BBCLASSEXTEND = "native"
