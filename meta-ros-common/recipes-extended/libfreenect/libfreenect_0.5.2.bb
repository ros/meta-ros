DESCRIPTION = "Drivers and libraries for the Xbox Kinect device"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://GPL2;md5=eb723b61539feef013de476e68b5c50a"

DEPENDS = "libusb1 freeglut libxi libxmu"

SRC_URI = "https://github.com/OpenKinect/libfreenect/archive/v${PV}.tar.gz;downloadfilename=${P}.tar.gz"
SRC_URI[md5sum] = "4d683cffe79f741aeb777cacaa88fd44"
SRC_URI[sha256sum] = "91af5c09b7eae217c4be69234ae5a6371f24da8ff6986f98c2db19f1993f2a71"

inherit cmake

#force libs always into /usr/lib, even when compiling on 64bit arch
EXTRA_OECMAKE += " -DLIB_SUFFIX=''"

FILES_${PN} += "\
    ${libdir}/fakenect/${BPN}.so.* \
    ${datadir}/fwfetcher.py \
    "
FILES_${PN}-dev += "${libdir}/fakenect/${BPN}.so" 
FILES_${PN}-dbg += "${libdir}/fakenect/.debug"

RDEPENDS_${PN} += "bash"
