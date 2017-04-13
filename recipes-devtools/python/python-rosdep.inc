DESCRIPTION = "rosdep package manager abstraction tool for ROS"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
SRCNAME = "rosdep"

SRC_URI = "http://download.ros.org/downloads/rosdep/rosdep-${PV}.tar.gz \
           file://0001-Remove-build-dependency-on-nose-from-setup.py-491.patch \
           "
SRC_URI[md5sum] = "2c5669bc5cafcb1df8cd21ce14844cc4"
SRC_URI[sha256sum] = "46e072074270a1ea25411829814f4bdc1f34b358c950e9b8a7b75b4a40efd96a"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} += "${PYTHON_PN}-catkin-pkg ${PYTHON_PN}-rospkg ${PYTHON_PN}-pyyaml ${PYTHON_PN}-netclient ${PYTHON_PN}-rosdistro"

BBCLASSEXTEND += "native"
