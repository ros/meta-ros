# Copyright (c) 2019-2021 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

DESCRIPTION = "This package wraps the libphidget22 to use it as a ROS dependency"
AUTHOR = "Martin Günther <martin.guenther@dfki.de>"
HOMEPAGE = "https://www.phidgets.com/"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=b46deb21a6e6c5cba0379736d1ae4b0d"

DEPENDS = "libusb1"

SRCNAME = "libphidget22"

SRC_URI = "https://www.phidgets.com/downloads/phidget22/libraries/linux/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
    https://raw.githubusercontent.com/ros-drivers/phidgets_drivers/rolling/libphidget22/patch/libphidget22-1.13.20230224-fix-warnings.patch;name=patch \
"
S = "${WORKDIR}/${SRCNAME}-${PV}"

SRC_URI[sha256sum] = "1d0795110517eb18c806472887cafc861dd0b6a1c1045246c555bc47f6bd77e3"
SRC_URI[patch.sha256sum] = "f72814e010526ec8affaff2886dc69f4d5dad4f34e562ff01ddcd69e44987081"

inherit autotools

# Resulting package can conflict with generated ROS recipe libphidget22, disable debian naming to
# keep libphidget22-upstream PN package name
AUTO_LIBNAME_PKGS = ""

do_configure:prepend() {
    # configure.ac uses this to define version (1.6 is taken from configure included in tarball, but autotools.bbclass runs autoreconf which fails without layer_version file)
    echo "1.13" > ${S}/library_version
}

do_install:append() {
    # for compatibility with phidgets-api which assumes libphidget22 directory like the ROS wrapper was installing it
    # phidgets-api/2.0.1-1-r0/git/src/gyroscope.cpp:35:10: fatal error: libphidget22/phidget22.h: No such file or directory
    ln -snf . ${D}${includedir}/libphidget22
}
