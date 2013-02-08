DESCRIPTION = "catkin package library"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=9d7780acc19bb1483beb724d32e59bef"
SRCNAME = "catkin_pkg"

SRC_URI = "http://pypi.python.org/packages/source/c/catkin_pkg/catkin_pkg-0.1.8.tar.gz"
SRC_URI[md5sum] = "ed7e9a15a2e9eaaf707add4c1f07e659"
SRC_URI[sha256sum] = "06fa265610333f8e37e1ed7c93075ddcbf7a3c26190dfd53ebb4d4cce35f6ae6"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

DEPENDS += "python"
DEPENDS_class-native  += "python-native"
BBCLASSEXTEND = "native"
