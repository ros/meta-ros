SUMMARY = "testfixtures is a collection of helpers and mock objects that are useful when writing automated tests in Python"

HOMEPAGE = "https://github.com/python/typing"
LICENSE = "Python-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=64fc2b30b67d0a8423c250e0386ed72f"

PYPI_PACKAGE = "typing_extensions"

inherit pypi
inherit setuptools3

SRC_URI[md5sum] = "98510adbacf8ea74f46f98b0a5cbdf73"
SRC_URI[sha256sum] = "2ed632b30bb54fc3941c382decfd0ee4148f5c591651c9272473fea2c6397d95"

BBCLASSEXTEND = "native"
