DESCRIPTION = "The installer for ROS"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
SRCNAME = "rosinstall"

SRC_URI = "http://download.ros.org/downloads/rosinstall/rosinstall-${PV}.tar.gz"
SRC_URI[md5sum] = "b52ea80b199efdb94e35229eb427965f"
SRC_URI[sha256sum] = "2ba808bf8bac2cc3f13af9745184b9714c1426e11d09eb96468611b2ad47ed40"

S = "${WORKDIR}/${SRCNAME}-${PV}"

DEPENDS += "python-vcstools python-pyyaml"
RDEPENDS_${PN} = "python-vcstools"

inherit setuptools
