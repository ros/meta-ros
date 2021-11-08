# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists-explicitly-link-with-pthread.patch"

DEPENDS += "\
    eigen3-cmake-module \
"
