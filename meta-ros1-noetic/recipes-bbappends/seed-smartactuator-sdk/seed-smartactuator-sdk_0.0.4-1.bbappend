# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-CMakeLists.txt-remove-signals-from-find_package-call.patch \
    file://0001-Fix-build-with-boost-1.73.0.patch \
"
