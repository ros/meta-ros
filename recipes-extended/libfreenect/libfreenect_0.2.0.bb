DESCRIPTION = "Drivers and libraries for the Xbox Kinect device"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://GPL2;md5=eb723b61539feef013de476e68b5c50a"

DEPENDS = "libusb1 freeglut libxi libxmu"

SRC_URI = "https://github.com/OpenKinect/libfreenect/archive/v${PV}.tar.gz;downloadfilename=libfreenect-${PV}.tar.gz"
SRC_URI[md5sum] = "575c1923ea666cfa5c4b7ad0cb549290"
SRC_URI[sha256sum] = "3318ebe32b59e23a1b9be290a61ee23a5ed1119365596eb1cb16f6579f837403"

SRC_URI += "file://0001-update-CMake-version-for-v0.2.0.patch"

inherit cmake

S = "${WORKDIR}/libfreenect-${PV}"

#force libs always into /usr/lib, even when compiling on 64bit arch
EXTRA_OECMAKE += " -DLIB_SUFFIX=''"

FILES_${PN} += "${libdir}/fakenect/libfreenect.so.*" 
FILES_${PN}-dev += "${libdir}/fakenect/libfreenect.so" 
FILES_${PN}-dbg += "${libdir}/fakenect/.debug"
