# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-prevent-building-zstd-with-ExternalPr.patch"

inherit pkgconfig

LICENSE = "Apache-2.0"
