# Copyright (c) 2021 LG Electronics, Inc.

DEPENDS += "yaml-cpp"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-face_detection-fix-build-with-gcc-11.patch \
"
