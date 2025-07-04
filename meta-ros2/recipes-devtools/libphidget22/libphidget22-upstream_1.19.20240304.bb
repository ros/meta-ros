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

SRC_URI = "https://www.phidgets.com/downloads/phidget22/libraries/linux/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${UNPACKDIR}/${SRCNAME}-${PV}"

SRC_URI[sha256sum] = "1a9cc6329434dacfd7fd711c1a8a33ccc8e282b6eabc0bbcd5b71bed01bedfa1"

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
