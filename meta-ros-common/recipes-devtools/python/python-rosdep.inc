DESCRIPTION = "rosdep package manager abstraction tool for ROS"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86a73ab7b555900fd6b51429658aca4c"
SRCNAME = "rosdep"

SRC_URI = "https://github.com/ros-infrastructure/rosdep/archive/${PV}.tar.gz;downloadfilename=${BP}.tar.gz"
SRC_URI[md5sum] = "c40eb20853f366e4fe0060e996b0f33e"
SRC_URI[sha256sum] = "da3e69167bad39f3f7ffb50b5d1e11bf6c83cbad3812e1a5bc44040a622201e4"

S = "${WORKDIR}/${SRCNAME}-${PV}"
# The Ubuntu version package has a "-<revision>" suffix, but the repo tag doesn't. Have the OE version package match the Ubuntu
# one; assume it's always "-1".
PKGV = "${PV}-1"

RDEPENDS_${PN} += "${PYTHON_PN}-catkin-pkg ${PYTHON_PN}-rospkg ${PYTHON_PN}-pyyaml ${PYTHON_PN}-netclient ${PYTHON_PN}-rosdistro"
RDEPENDS_${PN} += "ca-certificates"

BBCLASSEXTEND += "native"
