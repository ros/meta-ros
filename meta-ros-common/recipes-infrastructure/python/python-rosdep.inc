DESCRIPTION = "rosdep package manager abstraction tool for ROS"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86a73ab7b555900fd6b51429658aca4c"
SRCNAME = "rosdep"

SRCREV = "39cf7252405afb27bcfd11dc98e5edc6f801e2ef"
ROS_BRANCH ?= "branch=master"
SRC_URI = "git://github.com/ros-infrastructure/rosdep;${ROS_BRANCH};protocol=https"

S = "${WORKDIR}/git"

RDEPENDS_${PN} += "${PYTHON_PN}-catkin-pkg ${PYTHON_PN}-pyyaml ${PYTHON_PN}-netclient ${PYTHON_PN}-rosdistro"
RDEPENDS_${PN} += "ca-certificates"

BBCLASSEXTEND += "native"
