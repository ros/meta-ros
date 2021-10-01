# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-CMakeLists.txt-drop-dependency-on-zstd_vendor.patch \
    file://0002-CMakeLists.txt-link-against-zstd.patch \
"

# PN package in zstd-vendor is empty and not created, remove runtime dependency on it
ROS_EXEC_DEPENDS:remove = "zstd-vendor"

inherit pkgconfig
