# Copyright (c) 2020 LG Electronics, Inc.

CXXFLAGS += "-DOPENCV_TRAITS_ENABLE_DEPRECATED=1"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Make-it-compatible-with-OpenCV-4.patch"
