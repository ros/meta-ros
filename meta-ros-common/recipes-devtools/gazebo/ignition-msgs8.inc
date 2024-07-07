LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://LICENSE;md5=2e9f68f022747514564aa13818fcb7c6"

SRC_URI = "git://github.com/gazebosim/gz-msgs.git;protocol=https;branch=ign-msgs8 \
           file://add-libabsl-dependencies.patch"

PV = "8.7.0"
SRCREV = "f9acd44dd926433799e5e0c6f5f4af281bc72c57"

S = "${WORKDIR}/git"

inherit cmake
