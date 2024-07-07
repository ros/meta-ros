DESCRIPTION = "Drivers and libraries for the Xbox Kinect device"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://GPL2;md5=eb723b61539feef013de476e68b5c50a"

DEPENDS = "libusb1 freeglut libxi libxmu"

SRCREV = "f6de60f5291258920ca7d03e8d593f1bab3f7867"
ROS_BRANCH ?= "branch=master"
SRC_URI = "git://github.com/OpenKinect/libfreenect;${ROS_BRANCH};protocol=https"

S = "${WORKDIR}/git"

inherit cmake

#force libs always into /usr/lib, even when compiling on 64bit arch
##EXTRA_OECMAKE += " -DLIB_SUFFIX=''"

FILES:${PN} += "\
    ${libdir}/fakenect/*.so.* \
    ${datadir}/fwfetcher.py \
"
FILES:${PN}-dev += "${libdir}/fakenect/*.so"
FILES:${PN}-dbg += "${libdir}/fakenect/.debug"

RDEPENDS:${PN} += "bash"

inherit features_check
# Depends on freeglut with this restriction:
REQUIRED_DISTRO_FEATURES = "opengl"
# and libxi, libxmu, freeglut with this
REQUIRED_DISTRO_FEATURES += "x11"
