# Copyright (c) 2022 Wind River Systems, Inc.

# Use Bitbake to fetch https://github.com/foxglove/mcap.git
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
#SRC_URI += "file://0001-CMakeLists.txt-fetch-uncrustify-with-bitbake-fetcher.patch"
SRC_URI += " \
    git://github.com/foxglove/mcap.git;protocol=https;name=mcap;destsuffix=git/mcap;branch=main;lfs=0 \
    git://github.com/lz4/lz4.git;protocol=https;name=lz4;destsuffix=git/lz4;branch=release \
    git://github.com/facebook/zstd.git;protocol=https;name=zstd;destsuffix=git/zstd;branch=release \
    file://0001-CMakeLists.txt-fetch-dependencies-with-bitbake-fetch.patch\
"

# releases/cpp/v0.8.0
SRCREV_mcap = "801c4ae3f34b23e9a27eb34b88ab7a0180d4b40f"
# v1.9.3
SRCREV_lz4 = "d44371841a2f1728a3f36839fd4b7e872d0927d3"
# v1.5.2
SRCREV_zstd = "e47e674cd09583ff0503f0f6defd6d23d8b718d3"
#
# PN package in zstd-vendor is empty and not created, remove runtime dependency on it
ROS_EXEC_DEPENDS:remove = "zstd-vendor"

inherit pkgconfig
