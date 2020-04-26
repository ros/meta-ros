# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-search-for-boost_python37-instead-of-.patch"

# in thud it incorrectly detects python dependencies
inherit pythonnative
DEPENDS += "python-numpy-native"
