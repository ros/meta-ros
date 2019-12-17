DESCRIPTION = "ROS package library"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=988919d688133096537549f9afebf425"
SRCNAME = "rosdistro"

SRCREV = "2565c2c5e4add200dc8828d738e7c3d2c1850485"
ROS_BRANCH ?= "branch=master"
SRC_URI = "git://github.com/ros-infrastructure/rosdistro;${ROS_BRANCH};protocol=https"

S = "${WORKDIR}/git"

RDEPENDS_${PN} += "${PYTHON_PN}-pyyaml"

BBCLASSEXTEND = "native"
