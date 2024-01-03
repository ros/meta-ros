LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=b60de7db5b91c0b613d64e318151b0f1"

SRC_URI = "gitsm://github.com/simd-everywhere/simde.git;protocol=https;branch=master"

PV = "0.7.6+git${SRCPV}"
SRCREV = "fefc7857ff3e785b988a61a8f5f3c5bd5eb24342"

S = "${WORKDIR}/git"

inherit meson
