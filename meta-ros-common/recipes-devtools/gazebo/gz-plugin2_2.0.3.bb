# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-plugin.git;protocol=https;branch=gz-plugin2"

SRCREV = "23c28a25aa0c52c87378a28543723b73d475c417"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS = " \
  gz-cmake3 \
  gz-utils2 \
"

FILES:${PN} += " \
    ${datadir}/gz/gz2.completion.d/plugin2.bash_completion.sh \
    ${datadir}/gz/plugin2.yaml \
    ${libdir}/ruby/gz/cmdplugin2.rb \
"

BBCLASSEXTEND = "native nativesdk"
