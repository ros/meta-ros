DESCRIPTION = "Drivers and libraries for the Xbox Kinect device"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://GPL2;md5=eb723b61539feef013de476e68b5c50a"

DEPENDS = "libusb1 freeglut libxi libxmu"

SRC_URI = "https://github.com/OpenKinect/libfreenect/archive/v${PV}.tar.gz;downloadfilename=${P}.tar.gz"
SRC_URI[md5sum] = "95a3d8d2cc6a71db1bc53c579647fabf"
SRC_URI[sha256sum] = "9fdc348a12b9a7008f4ec20188666bf549e6bbbe3fe9199757c37332a286abfb"

inherit cmake

#force libs always into /usr/lib, even when compiling on 64bit arch
EXTRA_OECMAKE += " -DLIB_SUFFIX=''"

FILES_${PN} += "${libdir}/fakenect/${BPN}.so.*" 
FILES_${PN}-dev += "${libdir}/fakenect/${BPN}.so" 
FILES_${PN}-dbg += "${libdir}/fakenect/.debug"
