# Copyright (c) 2020-2021 LG Electronics, Inc.

DEPENDS += "libyaml"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-use-find-package-yaml.patch"
