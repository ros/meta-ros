DESCRIPTION = "Drivers and libraries for the Xbox Kinect device"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://GPL2;md5=eb723b61539feef013de476e68b5c50a"

DEPENDS = "libusb1 freeglut libxi libxmu"

SRC_URI = "https://github.com/OpenKinect/libfreenect/archive/v${PV}.tar.gz;downloadfilename=libfreenect-${PV}.tar.gz"
SRC_URI[md5sum] = "575c1923ea666cfa5c4b7ad0cb549290"
SRC_URI[sha256sum] = "3318ebe32b59e23a1b9be290a61ee23a5ed1119365596eb1cb16f6579f837403"

inherit cmake

S = "${WORKDIR}/libfreenect-${PV}"

FILES_${PN}-dev += "${libdir}/fakenect/libfreenect.so.0.1 ${libdir}/fakenect/libfreenect.so ${libdir}/fakenect/libfreenect.so.0.1.2" 
FILES_${PN}-dbg += "${libdir}/fakenect/.debug"
