# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# https://github.com/apache/incubator-tvm tag v0.7.0
# during do_compile
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-tvm-with-bitbake-fetcher.patch \
    git://github.com/apache/incubator-tvm.git;protocol=https;name=tvm-upstream;destsuffix=git/tvm-upstream;branch=main \
    https://raw.githubusercontent.com/autowarefoundation/tvm_vendor-release/release/foxy/tvm_vendor/0.7.0-1/config.cmake.patch;patchdir=tvm-upstream;name=patch \
"
SRCREV_tvm-upstream = "728b829575e5e690870b111ae2256cbe0f3dbe6f"
SRC_URI[patch.sha256sum] = "54ffe15d487171a9b338ac80b651394495d817d20f7050b68cf3b536ae856836"
