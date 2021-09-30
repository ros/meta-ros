# Copyright (c) 2019-2021 LG Electronics, Inc.

DEPENDS += "libyaml"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-libyaml-with-bitbake-fetcher.patch \
    file://0002-CMakeLists.txt-use-platform-libyaml-when-available-i.patch \
"

inherit pkgconfig

# Instead of fetching
# https://github.com/yaml/libyaml/archive/refs/tags/0.2.5.zip
# during do_compile
# git://github.com/yaml/libyaml.git;protocol=https;branch=release-0.2.5;name=libyaml;destsuffix=git/libyaml-upstream \
# SRCREV_libyaml = "65d19898a301b817261003b00d1dcef00895a7b4"
# oe-core/hardknott already has the right version:
# openembedded-core/meta/recipes-support/libyaml/libyaml_0.2.5.bb
