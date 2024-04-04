# Copyright (c) 2022 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
  git://github.com/ThePhD/sol2.git;name=upstream;destsuffix=git/sol2;branch=main;protocol=https \
  git://github.com/lua/lua;name=lua;destsuffix=git/lua;branch=master;protocol=https \
  file://0001-CMakeLists.txt-fetch-source-with-bitbake-fetcher.patch \
  file://0002-lua-source-dir.patch;patchdir=sol2 \
"

SRCREV_upstream = "eba86625b707e3c8c99bbfc4624e51f42dc9e561"
SRCREV_lua= "5d708c3f9cae12820e415d4f89c9eacbe2ab964b"
EXTRA_OECMAKE += "-DLUA_SOURCE_DIR=${S}/lua"
