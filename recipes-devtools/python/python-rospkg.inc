DESCRIPTION = "ROS package library"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
SRCNAME = "rospkg"

SRC_URI = "http://download.ros.org/downloads/rospkg/rospkg-${PV}.tar.gz"
SRC_URI[md5sum] = "36fa86450a397cbe531b214e088d06b7"
SRC_URI[sha256sum] = "ccd1d635319d41b79139b7336af64fc17a48a69ce0d728c1578c78f6350dbe1c"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} += "${PYTHON_PN}-xml"

BBCLASSEXTEND = "native"
