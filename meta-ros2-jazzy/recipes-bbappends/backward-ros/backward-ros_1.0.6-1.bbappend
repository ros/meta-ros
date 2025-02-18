# Copyright (c) 2021 LG Electronics, Inc.

DEPENDS += "ament-cmake-native"

BBCLASSEXTEND = "native nativesdk"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI:append = " file://0001-Add-CMAKE_SYSROOT-for-cross-compilation.patch"