DESCRIPTION = "Drivers and libraries for the Xbox Kinect device"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://GPL2;md5=eb723b61539feef013de476e68b5c50a"

DEPENDS = "libusb1 freeglut libxi libxmu"

SRCREV = "10a80abf425975e66b23898fdfa907a937e2391a"
ROS_BRANCH ?= "branch=master"
SRC_URI = "git://github.com/OpenKinect/libfreenect;${ROS_BRANCH};protocol=https"

S = "${WORKDIR}/git"

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

inherit features_check
# Depends on freeglut with this restriction:
REQUIRED_DISTRO_FEATURES = "opengl"
# and libxi, libxmu, freeglut with this
REQUIRED_DISTRO_FEATURES += "x11"
