# Copyright (c) 2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI += "\
    file://0001-update-tf2-convert-header.patch \
    file://disable-compiler-warnings.patch \
"

# apriltag-ros/3.1.2-1-r0/recipe-sysroot/usr/include/apriltag/common/matd.h:48:12: error: ISO C++ forbids flexible array member 'data' [-Werror=pedantic]
CXXFLAGS += "-Wno-error=pedantic"
