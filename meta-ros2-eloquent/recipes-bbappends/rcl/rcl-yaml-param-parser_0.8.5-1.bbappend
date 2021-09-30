# Copyright (c) 2020-2021 LG Electronics, Inc.

inherit pkgconfig

DEPENDS += "libyaml"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-use-pkg-config-to-find-yaml.patch"
