LICENSE = "CC0-1.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=65d3616852dbf7b1a6d4b53b00626032"

SRC_URI = "git://github.com/TartanLlama/expected.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

SRCREV = "v1.3.1"

inherit cmake

EXTRA_OECMAKE = "-DEXPECTED_BUILD_TESTS=FALSE"

