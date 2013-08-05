DESCRIPTION = "ROS package library"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=083869c8da6fdf8c3a5bbd7d1bf93cac"
SRCNAME = "rospkg"

SRC_URI = "http://pypi.python.org/packages/source/r/rospkg/rospkg-1.0.15.tar.gz"
SRC_URI[md5sum] = "3c9b1b8d1e90950944b3f10bad16ecff"
SRC_URI[sha256sum] = "f8be5a9d74f7e656d38b2c3b44b7e367fce4001d613ca3fbfcbb87c4937956f2"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} += "python-xml"

inherit setuptools

BBCLASSEXTEND = "native"
