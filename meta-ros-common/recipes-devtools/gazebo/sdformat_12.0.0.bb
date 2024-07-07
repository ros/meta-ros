# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://LICENSE;md5=881ceadb4a5b6db70a8a48a5f5f0050f"

SRC_URI = "git://github.com/gazebosim/sdformat.git;protocol=https;branch=main"

PV = "12.0.0+git${SRCPV}"
SRCREV = "c9494fbeaa36f45f085921f2b509a4074f3984ca"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

DEPENDS = " \
    ignition-cmake2 \
    ignition-math6 \
    ignition-tools1 \
    ignition-utils1 \
    libtinyxml2 \
    urdfdom \
    python3-psutil-native \
    ruby-native \
"

FILES:${PN} += " \
    ${libdir}/ruby/ignition/cmdsdformat12.rb \
    ${datadir}/ignition/sdformat12.yaml \
    ${datadir}/sdformat12/* \
"
