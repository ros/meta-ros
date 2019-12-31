DESCRIPTION = "catkin package library"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
PYPI_PACKAGE = "catkin_pkg"

DEPENDS = "${PYTHON_PN}-pyparsing"

SRC_URI[md5sum] = "10be85558c33e6406bb105becff4e7d0"
SRC_URI[sha256sum] = "18305748ae2de7ca7b10a560b146a9c0cb566130b6f4a4825f6f38595bf8488c"

inherit pypi

RDEPENDS_${PN} = "${PYTHON_PN}-unixadmin ${PYTHON_PN}-pyparsing ${PYTHON_PN}-dateutil ${PYTHON_PN}-docutils"
RDEPENDS_${PN}_class-native = ""

BBCLASSEXTEND = "native nativesdk"
