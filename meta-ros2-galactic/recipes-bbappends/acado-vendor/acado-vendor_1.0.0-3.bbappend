# Copyright (c) 2021 LG Electronics, Inc.

# Instead of fetching
# https://github.com/cho3/acado.git   GIT_TAG 8366e22cd5d815078e8d24f78dbced28b48d7e32
# https://github.com/cho3/hpmpc.git   GIT_TAG abbcf0806e4c8763ab2129a90efd827d194c1b00
# during do_compile
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-acado-hpmpc-with-bitbake-fetche.patch \
    git://github.com/cho3/acado.git;protocol=https;name=acado-upstream;destsuffix=git/acado-upstream;branch=submodule \
    file://0001-acado-cmake-CompilerOptions.cmake-don-t-set-march-native.patch;patchdir=acado-upstream \
    git://github.com/cho3/hpmpc.git;protocol=https;name=hpmpc-upstream;destsuffix=git/hpmpc-upstream;branch=submodule \
    file://0001-hpmpc-Don-t-clear-CMAKE_C_FLAGS.patch;patchdir=hpmpc-upstream \
"
SRCREV_acado-upstream = "8366e22cd5d815078e8d24f78dbced28b48d7e32"
SRCREV_hpmpc-upstream = "abbcf0806e4c8763ab2129a90efd827d194c1b00"
