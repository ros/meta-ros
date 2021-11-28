# Copyright (c) 2019-2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-CmakeLists.txt-set-C-version-to-C-14.patch \
"

DEPENDS += "eigen3-cmake-module"
