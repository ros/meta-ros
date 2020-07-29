# Copyright (c) 2020 LG Electronics, Inc.

# Instead of fetching
# https://github.com/modelon-community/fmi-library.git tag 2.1 with git
# during do_compile
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-fmi-library-with-bitbake-fetche.patch \
    git://github.com/modelon-community/fmi-library.git;protocol=https;name=fmi-library;destsuffix=git/fmi-library-upstream \
"
SRCREV_fmi-library = "d5ce0b923dd42fbc59b61edb17e837cd148e9501"
