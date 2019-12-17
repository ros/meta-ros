DESCRIPTION = "ROS package library"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/rospkg/__init__.py;beginline=1;endline=31;md5=9cea8ac73441707f7779ae66adf75f62"
SRCNAME = "rospkg"

SRCREV = "dbed1cfb80ef42f8e982e729922002bcf3b801bf"
ROS_BRANCH ?= "branch=master"
SRC_URI = "git://github.com/ros-infrastructure/rospkg;${ROS_BRANCH};protocol=https"

S = "${WORKDIR}/git"

RDEPENDS_${PN} += "${PYTHON_PN}-xml ${PYTHON_PN}-rosdep"

BBCLASSEXTEND = "native"
