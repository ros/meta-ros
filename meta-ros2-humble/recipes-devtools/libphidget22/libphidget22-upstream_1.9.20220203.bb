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
<<<<<<<< HEAD:meta-ros2-humble/recipes-devtools/libphidget22/libphidget22-upstream_1.4.20190605.bb
    https://raw.githubusercontent.com/ros2-gbp/phidgets_drivers-release/release/eloquent/${SRCNAME}/2.0.1-1/patch/libphidgets22-fix-uninitialized-memory-access.patch;name=patch \
"
S = "${WORKDIR}/${SRCNAME}-${PV}"

SRC_URI[md5sum] = "96e5d64263866d34e1d9a5f4ba78ba65"
SRC_URI[sha256sum] = "aa37bb070dd1a0be6bb011ad9e5a83e09fa301ef736c2cd54e00f4fdec6964a9"
SRC_URI[patch.md5sum] = "c44d05085f6cd9539b6f76c3c88a7f34"
SRC_URI[patch.sha256sum] = "a29bf26b2e2d51f122f29d17346b69dbbd809182373feb968b55c3d81279c565"
========
    https://raw.githubusercontent.com/ros2-gbp/phidgets_drivers-release/release/humble/libphidget22/patch/libphidget22-1.9.20220203-fix-warnings.patch;name=patch \
"
S = "${WORKDIR}/${SRCNAME}-${PV}"

SRC_URI[sha256sum] = "089d590bbc9dad9cc4b190a1acab96838fdddb4afab3315679009cb622852e06"
SRC_URI[patch.sha256sum] = "28ac732e72da543291b5fe6b7a6914752cde9c4774b83e943a46c2dab9546468"
>>>>>>>> 7b0e156d8 ({humble} libphidget22-upstream: Update to 1.9 (202202023)):meta-ros2-humble/recipes-devtools/libphidget22/libphidget22-upstream_1.9.20220203.bb

inherit autotools

do_configure_prepend() {
    # configure.ac uses this to define version (1.4 is taken from configure included in tarball, but autotools.bbclass runs autoreconf which fails without layer_version file)
    echo "1.4" > ${S}/library_version
}

do_install_append() {
    # for compatibility with phidgets-api which assumes libphidget22 directory like the ROS wrapper was installing it
    # phidgets-api/2.0.1-1-r0/git/src/gyroscope.cpp:35:10: fatal error: libphidget22/phidget22.h: No such file or directory
    ln -snf . ${D}${includedir}/libphidget22
}
