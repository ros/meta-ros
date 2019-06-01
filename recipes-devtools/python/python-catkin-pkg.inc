DESCRIPTION = "catkin package library"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
PYPI_PACKAGE = "catkin_pkg"

SRC_URI[md5sum] = "48f9ffd73a54282e8a33d124a24b5995"
SRC_URI[sha256sum] = "3aff32871b38630b2dad1b06eb96cac6b6b3f29adfef44f714fbdd3f12dba290"

inherit pypi

RDEPENDS_${PN} = "${PYTHON_PN}-unixadmin"
RDEPENDS_${PN}_class-native = ""

BBCLASSEXTEND = "native nativesdk"
