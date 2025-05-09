# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-math.git;protocol=https;branch=gz-math7"

SRCREV = "5072602c5ea8b8434a11d42f296aeedf1b695498"

S = "${WORKDIR}/git"

DEPENDS = " \
    gz-cmake3 \
    gz-cmake3-native \
    gz-utils2 \
    libeigen \
    python3 \
    python3-pybind11 \
    ruby \
    swig-native \
"

inherit cmake python3targetconfig

FILES:${PN} += "${libdir}/python/"

BBCLASSEXTEND = "native nativesdk"
