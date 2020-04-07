# Copyright (c) 2019-2020 LG Electronics, Inc.

# The value from package.xml "Check-author's-website" breaks parsing it with bitbake
LICENSE = "Zlib"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-Don-t-include-usr-include-and-usr-loc.patch"
