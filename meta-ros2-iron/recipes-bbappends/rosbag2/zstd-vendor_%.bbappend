# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2023 Acceleration Robotics

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
# SRC_URI += "file://0001-CMakeLists.txt-prevent-building-zstd-with-ExternalPr.patch"
# SRC_URI += "file://0001-rework-PATCH-CMakeLists.txt-prevent-building-zstd-wi.patch"
# SRC_URI += "file://0001-REWORK-CMakeLists.txt-prevent-building-zstd.patch"
SRC_URI += "file://0001-Langdale-fixes.patch"

inherit pkgconfig
