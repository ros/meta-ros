# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0002-mavgenerate.py-pymavlink-use-python3.patch \
"

DEPENDS += "python3-future-native"

inherit python3native
