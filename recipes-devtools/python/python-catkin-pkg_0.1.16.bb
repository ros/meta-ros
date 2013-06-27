DESCRIPTION = "catkin package library 0.1.16"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=748559ae3cef240be7edaaa8a4f4da31"
SRCNAME = "catkin_pkg"

SRC_URI = "https://pypi.python.org/packages/source/c/catkin_pkg/catkin_pkg-0.1.16.tar.gz"
SRC_URI[md5sum] = "851d3bdcdaa65a6a7bad8712a84c6915"
SRC_URI[sha256sum] = "342b866d718d831aa570dadcf6aff6a40508fe6a16b9bcf147c3ec7a7dab2b16"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

DEPENDS += "python"
DEPENDS_class-native  += "python-native"
BBCLASSEXTEND = "native"
