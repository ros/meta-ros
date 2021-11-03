# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# https://github.com/ros-safety/contracts_lite.git from tag 0.4.1
# during do_compile
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-install-only-the-header-files-not-who.patch \
    file://0002-CMakeLists.txt-fetch-contracts_lite-with-bitbake-fet.patch \
    git://github.com/ros-safety/contracts_lite.git;protocol=https;name=contracts-lite;destsuffix=git/contracts-lite-upstream;branch=master \
"
SRCREV_contracts-lite = "adeade26417cc8e8264a460e0d8cb8674a351ecf"
