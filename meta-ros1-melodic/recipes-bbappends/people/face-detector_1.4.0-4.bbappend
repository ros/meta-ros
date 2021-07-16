# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-CMakeLists.txt-remove-signals-from-find_package-call.patch \
    file://0001-face_detection-fix-build-with-gcc-11.patch \
"
