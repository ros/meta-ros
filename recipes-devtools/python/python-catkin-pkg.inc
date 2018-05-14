DESCRIPTION = "catkin package library"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
PYPI_PACKAGE = "catkin_pkg"

SRC_URI[md5sum] = "da93566c65dddfa9f821e18944c5ee5e"
SRC_URI[sha256sum] = "d4d069eaeb29d6a9ee71773b20c41515b6e0feb9ea2765ebaf3e599d0ceef050"

inherit pypi

RDEPENDS_${PN} = "${PYTHON_PN}-unixadmin"
RDEPENDS_${PN}_class-native = ""

BBCLASSEXTEND = "native nativesdk"
