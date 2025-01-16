DESCRIPTION = "C++ Library to communicate with Bitcraze Crazyflie"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=050441559d0bb3ca54ee8225f3ab90de"

SRC_URI = "git://github.com/whoenig/crazyflie_cpp.git;protocol=https;branch=master"

PV = "0.0.1+git${SRCPV}"
SRCREV = "8b8391bc8e1899b4704723d22b5e4fa43ddef763"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS = "libusb1"

FILES:${PN} += "${datadir}/crazyflie_cpp/package.xml"
