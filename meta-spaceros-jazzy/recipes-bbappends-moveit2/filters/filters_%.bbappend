# Copyright (c) 2020 LG Electronics, Inc.

LICENSE = "BSD-3-Clause"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-filter_base.hpp-use-unsigned-long-instead-of-size_t-.patch \
"
