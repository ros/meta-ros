# Copyright (c) 2021 LG Electronics, Inc.

DEPENDS += " \
    libtinyxml2 \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists-search-for-tinyxml2-instead-of-tinyxml.patch"

inherit pkgconfig
