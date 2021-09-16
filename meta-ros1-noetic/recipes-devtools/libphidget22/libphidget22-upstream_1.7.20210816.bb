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
    https://raw.githubusercontent.com/ros-drivers-gbp/phidgets_drivers-release/release/noetic/libphidget22/1.0.4-1/patch/libphidgets22-1.7.20210816-fix-warnings.patch;name=patch \
"
S = "${WORKDIR}/${SRCNAME}-${PV}"

SRC_URI[sha256sum] = "d34172cd6769e218ba69850d727d77dba75d0dfb58a3007cd3770c208ee1de7a"
SRC_URI[patch.sha256sum] = "9148f91fcbc2a2a123f178c47c3eea1435e6b5926b8e7447cc36ceee82aa3e77"

inherit autotools

# Resulting package can conflict with generated ROS recipe libphidget22, disable debian naming to
# keep libphidget22-upstream PN package name
AUTO_LIBNAME_PKGS = ""

do_configure:prepend() {
    # configure.ac uses this to define version (1.7 is taken from configure included in tarball, but autotools.bbclass runs autoreconf which fails without layer_version file)
    echo "1.7" > ${S}/library_version
}

do_install:append() {
    # for compatibility with phidgets-api which assumes libphidget22 directory like the ROS wrapper was installing it
    # phidgets-api/2.0.1-1-r0/git/src/gyroscope.cpp:35:10: fatal error: libphidget22/phidget22.h: No such file or directory
    ln -snf . ${D}${includedir}/libphidget22
}
