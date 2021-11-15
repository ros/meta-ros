# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-don-t-depend-on-zstd_vendor.patch \
    file://0002-CMakeLists.txt-prevent-duplicate-rule-for-domain_bri.patch \
"
