# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-math.git;protocol=https;branch=ign-math6"

SRCREV = "c5c3fc4f5f74a4b014834b8bfe4b995929dc2533"


DEPENDS = " \
    ruby-native \
    swig-native \
    python3 \
    python3-pybind11 \
    ignition-cmake2 \
"

inherit cmake python3-dir

DEPENDS = " \
    ignition-cmake2 \
    ignition-cmake2-native \
    libeigen \
"

BBCLASSEXTEND = "native nativesdk"
