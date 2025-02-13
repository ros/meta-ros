# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://LICENSE;md5=ba86179b62e9e2c25dd9184dd87e2464"

SRC_URI = " \
    git://github.com/gazebosim/gz-tools.git;protocol=https;branch=ign-tools1 \
"

SRCREV = "67d9d473aca6d33fb849e93e309cd678a75ccd71"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

EXTRA_OECMAKE = "-DUSE_SYSTEM_BACKWARDCPP:BOOL=ON"

DEPENDS = " \
    doxygen \
    jsoncpp \
    libyaml \
    libzip \
    backward-cpp \
"

FILES:${PN} = " \
    ${bindir}/ign \
    ${libdir}/libignition-tools-backward.so \
    ${datadir}/bash-completion/completions/ign \
    ${datadir}/gz/gz1.completion \
"

FILES:${PN}-dev = " \
    ${libdir}/pkgconfig/ignition-tools.pc \
    ${libdir}/cmake/ignition-tools/ignition-tools-config.cmake \
"

BBCLASSEXTEND = "native nativesdk"
