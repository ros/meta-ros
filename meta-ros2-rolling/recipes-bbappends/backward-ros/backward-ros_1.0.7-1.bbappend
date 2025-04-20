# Copyright (c) 2021 LG Electronics, Inc.

DEPENDS += "ament-cmake-native"

BBCLASSEXTEND = "native nativesdk"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-Backport-make-backward_rosConfig-cmake-relocatable.patch"
