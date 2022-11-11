# Copyright (c) 2022 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "git://github.com/stbrumme/hash-library.git;protocol=https;name=hash-library;destsuffix=git/hash-library-upstream;branch=master \
            file://0001-CMakeLists.txt-fetch-hash-library-with-bitbake-fetcher.patch"

SRCREV_hash-library = "70cc93763d49a24c4536c7f0a23248f9b40e30f5"
