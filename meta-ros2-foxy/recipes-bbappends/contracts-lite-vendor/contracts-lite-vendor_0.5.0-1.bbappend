# Copyright (c) 2020-2021 LG Electronics, Inc.

# Instead of fetching
# https://github.com/ros-safety/contracts_lite.git from tag 0.5.0
# during do_compile
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-install-only-the-header-files-not-who.patch \
    file://0002-CMakeLists.txt-fetch-contracts_lite-with-bitbake-fet.patch \
    git://github.com/ros-safety/contracts_lite.git;protocol=https;name=contracts-lite;destsuffix=git/contracts-lite-upstream;branch=master \
"
SRCREV_contracts-lite = "18c799230bcb997db86811944d2d1d9686a9c427"
