# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-math.git;protocol=https;branch=gz-math8"

SRCREV = "4b3b642a0fc2119df624968c7973b9e87f5925ee"

DEPENDS = " \
    gz-cmake4 \
    gz-cmake4-native \
    gz-utils3 \
    libeigen \
    python3 \
    python3-pybind11 \
    ruby \
    swig-native \
"

inherit cmake python3targetconfig

FILES:${PN} += "${libdir}/python/"

BBCLASSEXTEND = "native nativesdk"
