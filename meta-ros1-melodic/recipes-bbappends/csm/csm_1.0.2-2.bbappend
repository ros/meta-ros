# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-sm-CMakeLists.txt-use-include_directories-macro-to-r.patch \
"
