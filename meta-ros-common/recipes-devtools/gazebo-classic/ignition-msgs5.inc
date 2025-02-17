LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=2a461be67a1edf991251f85f3aadd1d0 \
                    file://LICENSE;md5=2e9f68f022747514564aa13818fcb7c6"

SRC_URI = "git://github.com/gazebosim/gz-msgs.git;protocol=https;branch=main \
           file://add-libabsl-dependencies.patch"

PV = "5.11"
SRCREV = "5296dff386aa0835027303a3b3209941ae005220"

S = "${WORKDIR}/git"

inherit cmake
