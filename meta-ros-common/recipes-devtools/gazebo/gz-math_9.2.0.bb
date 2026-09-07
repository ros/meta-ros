# Copyright (c) 2024 Wind River Systems, Inc.
SUMMARY = "General purpose math library for robot applications"
HOMEPAGE = "https://gazebosim.org/libs/math/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-math.git;protocol=https;branch=gz-math9"

SRCREV = "b80fcdbe092c0bddbd9264ed47770540b6be6389"

DEPENDS = " \
    gz-cmake \
    gz-cmake-native \
    gz-utils \
    libeigen \
    python3 \
    python3-pybind11 \
    ruby \
    swig-native \
"

inherit cmake python3targetconfig

FILES:${PN} += "${libdir}/python/"

BBCLASSEXTEND = "native nativesdk"
