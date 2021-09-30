# Copyright (c) 2020 LG Electronics, Inc.

DEPENDS += "jsoncpp"
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-use-pkg-config-to-find-jsoncpp.patch"

inherit pkgconfig
