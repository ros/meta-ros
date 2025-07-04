# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-fuel-tools;protocol=https;branch=gz-fuel-tools9"

SRCREV = "8bc5aa47ef5604b0ee4414699f9e36d8c8eb1db9"


inherit cmake

DEPENDS = " \
    gz-cmake3 \
    gz-common5 \
    gz-msgs10 \
    jsoncpp \
    libyaml \
    libzip \
    curl \
"

FILES:${PN} += " \
    ${libdir}/ruby/gz/cmdfuel9.rb \
    ${datadir}/gz/gz2.completion.d/fuel9.bash_completion.sh \
    ${datadir}/gz/fuel9.yaml \
    ${datadir}/gz/fuel_tools9/config.yaml \
"
