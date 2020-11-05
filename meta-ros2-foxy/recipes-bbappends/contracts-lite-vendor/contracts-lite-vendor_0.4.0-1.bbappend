# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# https://github.com/ros-safety/contracts_lite.git from tag 0.4.0
# during do_compile
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-install-only-the-header-files-not-who.patch \
    file://0002-CMakeLists.txt-fetch-contracts_lite-with-bitbake-fet.patch \
    git://github.com/ros-safety/contracts_lite.git;protocol=https;name=contracts-lite;destsuffix=git/contracts-lite-upstream \
"
SRCREV_contracts-lite = "1acd5be395eda3e5641d0e52e3f3e1aa29ed4cb3"
