LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4e5640559f0849cf863b1dc47bac078b"

SRC_URI = "git://github.com/luxonis/libnop.git;protocol=https;branch=cmake_support"

PV = "1.0+git${SRCPV}"
SRCREV = "2f19ad3ff3b40a323fa6777cb0b7594202769a72"

S = "${WORKDIR}/git"

inherit cmake

#ALLOW_EMPTY:${PN} = "1"