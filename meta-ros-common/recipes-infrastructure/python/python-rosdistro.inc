DESCRIPTION = "ROS package library"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=988919d688133096537549f9afebf425"
SRCNAME = "rosdistro"

SRCREV = "221369488df68ffcaed8c7a53983fd5b3e52866d"
ROS_BRANCH ?= "branch=master"
SRC_URI = "git://github.com/ros-infrastructure/rosdistro;${ROS_BRANCH};protocol=https"

S = "${WORKDIR}/git"

RDEPENDS:${PN} += "${PYTHON_PN}-pyyaml"

BBCLASSEXTEND = "native"
