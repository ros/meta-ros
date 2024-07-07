# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://LICENSE;md5=881ceadb4a5b6db70a8a48a5f5f0050f \
                    file://cli/LICENSE;md5=b73927b18d5c6cd8d2ed28a6ad539733"

SRC_URI = "git://github.com/gazebosim/gz-utils.git;protocol=https;branch=ign-utils1"

SRCREV = "36f5dfdbccd6cce7e02df14a2db19c6c2e784c49"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS = "ignition-cmake2"

BBCLASSEXTEND = "native nativesdk"
