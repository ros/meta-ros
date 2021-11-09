# Copyright (c) 2021 LG Electronics, Inc.

inherit python3targetconfig

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists-search-for-Python3-Development.patch"
