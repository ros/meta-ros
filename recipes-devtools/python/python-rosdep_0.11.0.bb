DESCRIPTION = "rosdep package manager abstraction tool for ROS"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
SRCNAME = "rosdep"

DEPENDS = "python-nose"

SRC_URI = "http://pypi.python.org/packages/source/r/rosdep/rosdep-${PV}.tar.gz"
SRC_URI[md5sum] = "c1e3f200d9beddb5c70cc0a74ab47734"
SRC_URI[sha256sum] = "6d043e1fb58d8b366f90b63ccfaff3140416bf1a6f4014bb3bb1b85af7a77073"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} += "python-catkin-pkg python-rospkg python-pyyaml python-netclient"

inherit setuptools

BBCLASSEXTEND += "native"
