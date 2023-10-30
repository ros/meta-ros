# Copyright (c) 2019-2021 LG Electronics, Inc.
# Copyright (c) 2019-2022 Wind River Systems, Inc.

DEPENDS += "libyaml"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-libyaml-with-bitbake-fetcher.patch \
    file://0002-CMakeLists.txt-use-platform-libyaml-when-available-i.patch \
"

inherit pkgconfig
