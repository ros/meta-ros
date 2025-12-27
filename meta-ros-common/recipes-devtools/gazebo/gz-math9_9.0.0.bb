# Copyright (c) 2024 Wind River Systems, Inc.
SUMMARY = "General purpose math library for robot applications"
HOMEPAGE = "https://gazebosim.org/libs/math/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-math.git;protocol=https;branch=${BPN}"

SRCREV = "31dda2d7f1fa399b1e270db2770c33fc0c6dc7bf"

DEPENDS = " \
    gz-cmake5 \
    gz-cmake5-native \
    gz-utils4 \
    libeigen \
    python3 \
    python3-pybind11 \
    ruby \
    swig-native \
"

inherit cmake python3targetconfig

FILES:${PN} += "${libdir}/python/"

BBCLASSEXTEND = "native nativesdk"
