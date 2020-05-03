# Copyright (c) 2020 LG Electronics, Inc.

inherit pythonnative

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-search-for-boost_python37-instead-of-.patch"

do_configure_append() {
    # Fixes this:
    # pinocchio/2.3.1-1-r0/recipe-sysroot/usr/include/c++/8.2.0/cstdlib:75:15: fatal error: stdlib.h: No such file or directory
    #  #include_next <stdlib.h>
    sed -i 's/-isystem /-I/g' ${B}/build.ninja
}
