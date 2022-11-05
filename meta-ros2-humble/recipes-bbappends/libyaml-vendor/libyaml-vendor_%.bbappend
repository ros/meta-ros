# Copyright (c) 2019-2021 LG Electronics, Inc.

DEPENDS += "libyaml"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0002-CMakeLists.txt-use-platform-libyaml-when-available-i.patch"
