LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=d9bb71e9e345a6737e3fa9200b9f1c59"

FILESEXTRAPATHS:prepend := "${THISDIR}/python-botocore:"
SRC_URI = "git://github.com/jlblancoc/nanoflann.git;protocol=https;branch=master \
           file://disable-compiler-options.patch"

PV = "1.7.1+git"
SRCREV = "9a653cb243db6a09c94f833b28732b62f033e2b5"

inherit cmake pkgconfig

DEPENDS += "libeigen googletest"

EXTRA_OECMAKE = " \
    -DNANOFLANN_BUILD_EXAMPLES=OFF \
    -DNANOFLANN_USE_SYSTEM_GTEST=ON \
"
