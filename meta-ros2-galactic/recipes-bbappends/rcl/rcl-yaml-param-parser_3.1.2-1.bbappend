# Copyright (c) 2020-2021 LG Electronics, Inc.

inherit pkgconfig

DEPENDS += "libyaml"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += " \
    file://0001-CMakeLists.txt-fix-find_library-libyaml.patch \
"
