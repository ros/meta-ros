DESCRIPTION = "The installer for ROS"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=e910b35b0ef4e1f665b9a75d6afb7709"
SRCNAME = "rosinstall"

SRC_URI = "https://pypi.python.org/packages/source/r/rosinstall/rosinstall-${PV}.tar.gz"
SRC_URI[md5sum] = "fd49a9cc6ede3d1bf4932effdac414e9"
SRC_URI[sha256sum] = "65de7c1594e80799b2da68fc7c1d466bbec08a0cedd61437ae276e90f8cff411"

S = "${WORKDIR}/${SRCNAME}-${PV}"

DEPENDS += "python-vcstools python-pyyaml"
RDEPENDS_${PN} = "python-vcstools"

inherit setuptools
