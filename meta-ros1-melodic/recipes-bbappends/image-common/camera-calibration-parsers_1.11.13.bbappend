# Copyright (c) 2019-2020 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
     file://0001-CMakeLists.txt-search-for-boost_python37-instead-of-.patch \
"

inherit pkgconfig
