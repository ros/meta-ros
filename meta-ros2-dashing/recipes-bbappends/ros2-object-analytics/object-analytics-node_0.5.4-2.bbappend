# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-organized_multi_plane_segmenter.cpp-use-newer-setExc.patch \
"
