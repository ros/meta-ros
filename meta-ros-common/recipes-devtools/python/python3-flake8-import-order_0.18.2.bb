DESCRIPTION = "Flake8 plugin that checks import order against various Python Style Guides"
HOMEPAGE = "https://github.com/PyCQA/flake8-import-order"
SECTION = "devel/python"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=e6a600fd5e1d9cbde2d983680233ad02"

SRC_URI[sha256sum] = "e23941f892da3e0c09d711babbb0c73bc735242e9b216b726616758a920d900e"

inherit setuptools3 pypi

BBCLASSEXTEND = "native"
