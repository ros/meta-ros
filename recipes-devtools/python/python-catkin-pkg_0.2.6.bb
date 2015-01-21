DESCRIPTION = "catkin package library"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
SRCNAME = "catkin_pkg"

SRC_URI = "https://pypi.python.org/packages/source/c/catkin_pkg/catkin_pkg-${PV}.tar.gz"
SRC_URI[md5sum] = "d1b82c9e3acd873e6a07e2c932f4bea4"
SRC_URI[sha256sum] = "7d3d955ec1848565ccfee18e685cf1bd677cdd03283a00d22fb271e072aa48fa"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

BBCLASSEXTEND = "native"
