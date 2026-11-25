# Copyright (c) 2022-2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0"
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Add-map-to-udppacketmerger.patch \
    file://add-cstdint.patch"

# sick-safetyscanners-base/1.0.2-1/git/src/SickSafetyscanners.cpp:54:16: error: moving a temporary object prevents copy elision [-Werror=pessimizing-move]
CXXFLAGS += "-Wno-error=pessimizing-move"
