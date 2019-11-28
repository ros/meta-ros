SUMMARY = "a fork of Python 2 and 3 ast modules with type comment support"
DESCRIPTION = "Modified fork of CPython's ast module that parses `# type:` comments"
HOMEPAGE = "https://github.com/python/typed_ast"
LICENSE = "Apache-2.0 & EXPAT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=97f1494e93daf66a5df47118407a4c4f"

PYPI_PACKAGE = "typed_ast"

inherit pypi
inherit setuptools3

SRC_URI[md5sum] = "9a3dd35e136427313465faa75f3110da"
SRC_URI[sha256sum] = "66480f95b8167c9c5c5c87f32cf437d585937970f3fc24386f313a4c97b44e34"

BBCLASSEXTEND = "native"
