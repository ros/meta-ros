# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-math.git;protocol=https;branch=gz-math7"

SRCREV = "dd288136cd4f740feed0f28bfd904fae2b3fe0d6"


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
