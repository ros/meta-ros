DESCRIPTION = "ROS package library"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
SRCNAME = "rospkg"

SRC_URI = "http://pypi.python.org/packages/source/r/rospkg/rospkg-${PV}.tar.gz"
SRC_URI[md5sum] = "2c3c217ede5d5175e151756d6bf6bcf8"
SRC_URI[sha256sum] = "8b00a013d40c2140ed2081ce41798ce1c9b00ba5757a8aafa783de6cd74d2d38"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} += "python-xml"

inherit setuptools

BBCLASSEXTEND = "native"
