DESCRIPTION = "rosdep package manager abstraction tool for ROS"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86a73ab7b555900fd6b51429658aca4c"
SRCNAME = "rosdep"

SRCREV = "ac8484eb382302c5ab8f72355cfd0dce4474e542"
ROS_BRANCH ?= "branch=master"
SRC_URI = "git://github.com/ros-infrastructure/rosdep;${ROS_BRANCH};protocol=https"

S = "${WORKDIR}/git"

RDEPENDS:${PN} += "${PYTHON_PN}-catkin-pkg ${PYTHON_PN}-pyyaml ${PYTHON_PN}-netclient ${PYTHON_PN}-rosdistro"
RDEPENDS:${PN} += "ca-certificates"

BBCLASSEXTEND += "native"
