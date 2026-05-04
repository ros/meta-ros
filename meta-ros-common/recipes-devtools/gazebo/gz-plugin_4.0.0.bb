# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-plugin.git;protocol=https;branch=gz-plugin4"

SRCREV = "7af02e6a02350d42cdbce7ce8667b4571e6710f3"


inherit cmake

DEPENDS = " \
  gz-cmake \
  gz-tools \
  gz-utils \
"

FILES:${PN} += " \
    ${datadir}/gz/gz2.completion.d/plugin4.bash_completion.sh \
    ${datadir}/gz/plugin4.yaml \
    ${libdir}/ruby/gz/cmdplugin4.rb \
"

BBCLASSEXTEND = "native nativesdk"
