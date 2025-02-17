# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-fuel-tools;protocol=https;branch=gz-fuel-tools9"

SRCREV = "931f139b00e37fe764ee05a5ec40e695c1c323af"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS = " \
    ignition-cmake2 \
    ignition-common3 \
    ignition-msgs5 \
    ignition-tools1 \
    jsoncpp \
    libyaml \
    libzip \
    curl \
"

FILES:${PN} += " \
    ${libdir}/ruby/ignition/cmdfuel4.rb \
    ${datadir}/gz/gz1.completion.d/fuel4.bash_completion.sh \
    ${datadir}/ignition/fuel4.yaml \
    ${datadir}/ignition/fuel_tools4/config.yaml \
"

BBCLASSEXTEND = "native nativesdk"
