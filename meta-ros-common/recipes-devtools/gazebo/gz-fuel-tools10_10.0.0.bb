# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-fuel-tools;protocol=https;branch=gz-fuel-tools10"

SRCREV = "93803c78dc55a978e39dfbb2a89d47585ff3c999"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS = " \
    gz-cmake4 \
    gz-common6 \
    gz-msgs11 \
    jsoncpp \
    libyaml \
    libzip \
    curl \
"

FILES:${PN} += " \
    ${libdir}/ruby/gz/cmdfuel10.rb \
    ${datadir}/gz/gz2.completion.d/fuel10.bash_completion.sh \
    ${datadir}/gz/fuel10.yaml \
    ${datadir}/gz/fuel_tools10/config.yaml \
"
