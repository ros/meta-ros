# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-fix-vp9-and-h264-support-for-opencv4-and-ffmpeg-4-10.patch \
    file://0001-Fix-build-with-boost-1.73.0.patch \
"

inherit pkgconfig
