DESCRIPTION = "catkin package library"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
PYPI_PACKAGE = "catkin_pkg"

DEPENDS = "${PYTHON_PN}-pyparsing"

SRC_URI[sha256sum] = "28ee181cca827c0aabf9397351f58a97e1475ca5ac7c106a5916e3ee191cd3d0"

inherit pypi

RDEPENDS:${PN} = "${PYTHON_PN}-unixadmin ${PYTHON_PN}-pyparsing ${PYTHON_PN}-dateutil ${PYTHON_PN}-docutils"
RDEPENDS:${PN}:class-native = ""

BBCLASSEXTEND = "native nativesdk"
