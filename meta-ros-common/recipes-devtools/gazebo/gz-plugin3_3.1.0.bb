# Copyright (c) 2024 Wind River Systems, Inc.
SUMMARY = "Cross-platform C++ library for dynamically loading plugins"
HOMEPAGE = "https://gazebosim.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

DEPENDS = "\
    gz-cmake4 \
    gz-tools2 \
    gz-utils3 \
"

SRC_URI = "git://github.com/gazebosim/gz-plugin.git;protocol=https;branch=gz-plugin3"

SRCREV = "4341e1bc4d5d5479048f3f7cf5e371f6cd182a08"

inherit cmake

FILES:${PN} += "\
    ${datadir}/gz/gz3.completion.d/plugin3.bash_completion.sh \
    ${datadir}/gz/plugin3.yaml \
    ${libdir}/ruby/gz/cmdplugin3.rb \
"

BBCLASSEXTEND = "native nativesdk"
