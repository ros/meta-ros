# Copyright (c) 2024 Wind River Systems, Inc.
SUMMARY = "A client library and command line tools for interacting with Gazebo Fuel servers"
HOMEPAGE = "https://gazebosim.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

DEPENDS = "\
    curl \
    gz-cmake4 \
    gz-common6 \
    gz-msgs11 \
    jsoncpp \
    libyaml \
    libzip \
"

SRC_URI = "git://github.com/gazebosim/gz-fuel-tools;protocol=https;branch=gz-fuel-tools10"

SRCREV = "84842609463393207786494b22cea539b8f159c3"

inherit cmake

FILES:${PN} += "\
    ${libdir}/ruby/gz/cmdfuel10.rb \
    ${datadir}/gz/gz2.completion.d/fuel10.bash_completion.sh \
    ${datadir}/gz/fuel10.yaml \
    ${datadir}/gz/fuel_tools10/config.yaml \
"

BBCLASSEXTEND = "native nativesdk"
