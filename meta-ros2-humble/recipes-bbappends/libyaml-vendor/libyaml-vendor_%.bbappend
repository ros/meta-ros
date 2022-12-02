# Copyright (c) 2019-2020 LG Electronics, Inc.

DEPENDS += "libyaml"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-libyaml-with-bitbake-fetcher.patch \
    file://0001-CMakeLists.txt-use-platform-libyaml-when-available-i.patch \
"

# Instead of fetching
# https://github.com/yaml/libyaml/archive/10c907871f1ccd779c7fccf6b81a62762b5c4e7b.zip
# during do_compile
# git://github.com/yaml/libyaml.git;protocol=https;branch=release-0.1.8;name=libyaml;destsuffix=git/libyaml-upstream \
# SRCREV_libyaml = "10c907871f1ccd779c7fccf6b81a62762b5c4e7b"
