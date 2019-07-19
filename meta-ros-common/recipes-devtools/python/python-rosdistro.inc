DESCRIPTION = "ROS package library"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=988919d688133096537549f9afebf425"
SRCNAME = "rosdistro"

SRC_URI = "https://github.com/ros-infrastructure/rosdistro/archive/${PV}.tar.gz;downloadfilename=${BP}.tar.gz"
SRC_URI[md5sum] = "011634b410f9f5ba1d05ac352dbd9ff0"
SRC_URI[sha256sum] = "94caf9c03142744cbcd1ab926a216ee64d5e1d27c35c15c7262565761f3a053c"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} += "${PYTHON_PN}-pyyaml"

BBCLASSEXTEND = "native"
