# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = " \
    git://github.com/gazebosim/gz-tools.git;protocol=https;branch=gz-tools2 \
"

SRCREV = "efcc504bd3665151266f38db627c9095e5a5773f"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "-DUSE_SYSTEM_BACKWARDCPP:BOOL=ON"

DEPENDS = " \
    doxygen \
    jsoncpp \
    libyaml \
    libzip \
    backward-cpp \
    gz-cmake4 \
"


FILES:${PN} = " \
    ${bindir}/gz \
    ${datadir}/bash-completion/completions/gz \
    ${libdir}/libgz-tools2-backward.so.2 \
    ${libdir}/libgz-tools2-backward.so.2.0.1 \
    ${datadir}/gz/gz.completion \
"

FILES:${PN}-dev = " \
    ${libdir}/libgz-tools2-backward.so \
    ${libdir}/pkgconfig/gz-tools.pc \
    ${libdir}/cmake/gz-tools2-all/gz-tools2-all-config-version.cmake \
    ${libdir}/cmake/gz-tools2-all/gz-tools2-all-targets.cmake \
    ${libdir}/cmake/gz-tools2-all/gz-tools2-all-config.cmake \
"

BBCLASSEXTEND = "native nativesdk"
