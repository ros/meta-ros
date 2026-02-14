LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c12cbcb0f50cce3b0c58db4e3db8c2da"

SRC_URI = "git://github.com/xtensor-stack/xtl.git;protocol=https;branch=master"

PV = "0.7.7+git${SRCPV}"
SRCREV = "d9c4d02cfe89ca62545c1c8f81a685d0349df83a"

inherit cmake

DEPENDS = "nlohmann-json"
