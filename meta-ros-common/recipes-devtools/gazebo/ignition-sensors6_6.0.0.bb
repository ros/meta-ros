# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://LICENSE;md5=403837d405a17669732f6a98e3f42aed"

SRC_URI = "git://github.com/gazebosim/gz-sensors.git;protocol=https;branch=ign-sensors6"

SRCREV = "b0c61c5853f204372018161c5224c17dc523ad9c"

S = "${WORKDIR}/git"

DEPENDS += " \
    ignition-cmake2 \
    ignition-common4 \
    ignition-math6 \
    ignition-msgs8 \
    ignition-rendering6 \
    ignition-transport11 \
    protobuf \
"

inherit cmake
