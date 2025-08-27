# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/sdformat.git;protocol=https;branch=sdf14"

SRCREV = "d6db8037057478e11962015f31e350a12262fd51"

S = "${WORKDIR}/git"

inherit cmake pkgconfig python3targetconfig

DEPENDS = " \
    gz-cmake-vendor \
    gz-math-vendor \
    gz-tools-vendor \
    gz-utils-vendor \
    libtinyxml2 \
    python3-pybind11 \
    python3-psutil-native \
    ruby-native \
    urdfdom \
"

PACKAGES =+ "python3-${PN}"

FILES:${PN} += " \
    ${libdir}/ruby/gz \
    ${datadir}/gz \
    ${datadir}/sdformat14/* \
"

FILES:python3-${PN} += " \
    ${libdir}/python \
"
