# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# https://github.com/delmottea/libCMT.git e4d7ea42edafe13b1070ef4d595b2d6062d79d1a with git
#     GIT_TAG e4d7ea42edafe13b1070ef4d595b2d6062d79d1a
#
# during do_compile
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-libcmt-with-bitbake-fetcher.patch \
    git://github.com/delmottea/libCMT.git;protocol=https;name=libcmt-upstream;destsuffix=git/libcmt-upstream \
"
SRCREV_libcmt-upstream = "e4d7ea42edafe13b1070ef4d595b2d6062d79d1a"

# CMakeLists.txt just calls make install in libcmt-ustream, which doesn't work
# as we're using ninja by default, lets do what cmake.bbclass does, just inside
# libcmt
do_install() {
    DESTDIR='${D}' VERBOSE=1 cmake --build '${B}/libcmt-prefix/src/libcmt-build/' --target ${OECMAKE_TARGET_INSTALL} -- ${EXTRA_OECMAKE_BUILD}
}
