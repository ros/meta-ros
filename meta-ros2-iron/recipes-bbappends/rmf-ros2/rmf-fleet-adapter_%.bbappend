# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-FleetUpdateHandle-use-uint64_t-instead-of-std-size_t.patch \
"
