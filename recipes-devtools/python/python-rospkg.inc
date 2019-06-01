DESCRIPTION = "ROS package library"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/rospkg/__init__.py;beginline=1;endline=31;md5=9cea8ac73441707f7779ae66adf75f62"
SRCNAME = "rospkg"

SRC_URI = "https://github.com/ros-infrastructure/rospkg/archive/${PV}.tar.gz;downloadfilename=${BP}.tar.gz"
SRC_URI[md5sum] = "e12b3d78e78be1677a84948ecf83bc58"
SRC_URI[sha256sum] = "735edfb831525e85d02e015bcefd277252fc018ead857dce4889fc60f529ba3e"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} += "${PYTHON_PN}-xml"

BBCLASSEXTEND = "native"
