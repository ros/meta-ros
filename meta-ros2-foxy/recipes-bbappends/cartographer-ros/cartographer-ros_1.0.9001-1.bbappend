# Copyright (c) 2019-2020 LG Electronics, Inc.

DEPENDS += "eigen3-cmake-module"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://cmake.dont.add.isystem.patch \
"
