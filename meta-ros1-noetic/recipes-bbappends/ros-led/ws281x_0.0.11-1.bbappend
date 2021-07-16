# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "\
    file://0001-version-rename-ambiguous-version.h-to-ws281x-version.patch \
    file://0002-CMakeLists.txt-don-t-enable-INSTALL_RPATH_USE_LINK_P.patch \
"
