# Copyright (c) 2020 LG Electronics, Inc.

do_configure_append() {
    # Fixes this:
    # image-cb-detector/0.10.14-r0/recipe-sysroot/usr/include/c++/8.2.0/cstdlib:75:15: fatal error: stdlib.h: No such file or directory
    sed -i 's/-isystem /-I/g' ${B}/build.ninja
}

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-CMakeLists.txt-remove-signals-from-find_package-call.patch \
"
