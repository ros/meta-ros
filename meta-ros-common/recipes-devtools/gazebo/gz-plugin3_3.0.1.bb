# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-plugin.git;protocol=https;branch=gz-plugin3"

SRCREV = "4c0ba4bef006d9a395023c46bc7cce4b0dc626aa"


inherit cmake

DEPENDS = " \
  gz-cmake4 \
  gz-tools2 \
  gz-utils3 \
"

FILES:${PN} += " \
    ${datadir}/gz/gz3.completion.d/plugin3.bash_completion.sh \
    ${datadir}/gz/plugin3.yaml \
    ${libdir}/ruby/gz/cmdplugin3.rb \
"

BBCLASSEXTEND = "native nativesdk"
