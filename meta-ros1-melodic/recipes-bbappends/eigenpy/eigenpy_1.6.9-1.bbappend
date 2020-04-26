# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-search-for-boost_python37-instead-of-.patch"

# in thud it incorrectly detects python dependencies
inherit pythonnative
DEPENDS += "python-numpy-native"

do_configure_append() {
    # Fixes this:
    # eigenpy/1.6.9-1-r0/recipe-sysroot/usr/include/c++/8.2.0/cstdlib:75:15: fatal error: stdlib.h: No such file or directory
    sed -i 's/-isystem /-I/g' ${B}/build.ninja
}
