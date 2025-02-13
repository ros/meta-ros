# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://LICENSE;md5=2e9f68f022747514564aa13818fcb7c6"

SRC_URI = "git://github.com/gazebosim/gz-plugin.git;protocol=https;branch=ign-plugin1"

SRCREV = "1d5a4c987668ed0584ddbf4398dc81b519412c54"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS = "ignition-cmake2"

FILES:${PN} += " \
    ${datadir}/gz/gz1.completion.d/plugin1.bash_completion.sh \
    ${datadir}/ignition/plugin1.yaml \
    ${libdir}/ruby/ignition/cmdplugin1.rb \
"

BBCLASSEXTEND = "native nativesdk"
