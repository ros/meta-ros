# Copyright (c) 2019-2021 LG Electronics, Inc.

DESCRIPTION = "This package wraps the libphidget22 to use it as a ROS dependency"
AUTHOR = "Martin Günther <martin.guenther@dfki.de>"
HOMEPAGE = "https://www.phidgets.com/"
SECTION = "devel"
LICENSE = "LGPL-3.0+"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504 \
    file://COPYING.LESSER;md5=e6a600fd5e1d9cbde2d983680233ad02 \
"

DEPENDS = "libusb1"

SRCNAME = "libphidget22"

SRC_URI = "https://www.phidgets.com/downloads/phidget22/libraries/linux/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
    https://raw.githubusercontent.com/ros2-gbp/phidgets_drivers-release/release/rolling/libphidget22/2.2.1-1/patch/libphidgets22-1.6.20210312-fix-warnings.patch;name=patch \
"
S = "${WORKDIR}/${SRCNAME}-${PV}"

SRC_URI[sha256sum] = "9e17adc704a4cc923f1e75af74897af65da36d863df0f069a2c912cd63d47070"
SRC_URI[patch.sha256sum] = "00aa71a94773cfd9ca4db0741415699b5c11de1e803ad973130d0b14f298f141"

inherit autotools

# Resulting package can conflict with generated ROS recipe libphidget22, disable debian naming to
# keep libphidget22-upstream PN package name
AUTO_LIBNAME_PKGS = ""

do_configure:prepend() {
    # configure.ac uses this to define version (1.6 is taken from configure included in tarball, but autotools.bbclass runs autoreconf which fails without layer_version file)
    echo "1.6" > ${S}/library_version
}

do_install:append() {
    # for compatibility with phidgets-api which assumes libphidget22 directory like the ROS wrapper was installing it
    # phidgets-api/2.0.1-1-r0/git/src/gyroscope.cpp:35:10: fatal error: libphidget22/phidget22.h: No such file or directory
    ln -snf . ${D}${includedir}/libphidget22
}
