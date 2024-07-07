# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-fuel-tools;protocol=https;branch=ign-fuel-tools7"

SRCREV = "0bdbb7a0f54a6db260abcc391de064662f193d3e"

S = "${WORKDIR}/git"

inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

DEPENDS = " \
    ignition-cmake2 \
    ignition-common4 \
    ignition-msgs8 \
    jsoncpp \
    libyaml \
    libzip \
    curl \
"

FILES:${PN} += " \
    ${libdir}/ruby/ignition/cmdfuel7.rb \
    ${datadir}/gz/gz1.completion.d/fuel7.bash_completion.sh \
    ${datadir}/ignition/fuel7.yaml \
    ${datadir}/ignition/fuel_tools7/config.yaml \
"
