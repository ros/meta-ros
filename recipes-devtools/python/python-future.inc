DESCRIPTION = "Clean single-source support for Python 3 and 2"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3f457538b297bd0ef86564b8ac216ad7"
PYPI_PACKAGE = "future"

SRC_URI[md5sum] = "3e8e88a2bda48d54b1da7634d04760d7"
SRC_URI[sha256sum] = "e39ced1ab767b5936646cedba8bcce582398233d6a627067d4c6a454c90cfedb"

inherit pypi

BBCLASSEXTEND += "native"
