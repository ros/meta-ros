LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c12cbcb0f50cce3b0c58db4e3db8c2da"

SRC_URI = "git://github.com/xtensor-stack/xtl.git;protocol=https;branch=master"

PV = "0.7.7+git${SRCPV}"
SRCREV = "a7c1c5444dfc57f76620391af4c94785ff82c8d6"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS = "nlohmann-json"
