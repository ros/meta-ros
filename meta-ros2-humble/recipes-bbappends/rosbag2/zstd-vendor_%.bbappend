# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
#SRC_URI += "file://0001-CMakeLists.txt-prevent-building-zstd-with-ExternalPr.patch"
SRC_URI += "file://0001-rework-PATCH-CMakeLists.txt-prevent-building-zstd-wi.patch"

inherit pkgconfig
