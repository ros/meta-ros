DESCRIPTION = "ROS package library"
SECTION = "devel/python"
LICENSE = "BSD & MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=48623a4c0f1b1f65fae1dedd990a7f54"
SRCNAME = "rosdistro"

SRC_URI = "http://download.ros.org/downloads/rosdistro/rosdistro-${PV}.tar.gz"
SRC_URI[md5sum] = "a699690fab755fd1b92b2ac04933e227"
SRC_URI[sha256sum] = "f44757336bcee4089f6f6d570248e7c4e09eebfe5238d6ae60d8bd35361eedc4"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} += "${PYTHON_PN}-pyyaml"

BBCLASSEXTEND = "native"
