DESCRIPTION = "nose extends unittest to make testing easier"
SECTION = "devel/python"
LICENSE = "GNU LPGL"
LIC_FILES_CHKSUM = "file://lgpl.txt;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRCNAME = "nose"

SRC_URI = "http://pypi.python.org/packages/source/n/nose/nose-1.2.1.tar.gz"
SRC_URI[md5sum] = "735e3f1ce8b07e70ee1b742a8a53585a"
SRC_URI[sha256sum] = "2171e9202d118d302d5db1decb52dd862b79e2a626ca19653a6914574a6ca7d9"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

DEPENDS += "python"
DEPENDS_class-native  += "python-native"
BBCLASSEXTEND = "native"

