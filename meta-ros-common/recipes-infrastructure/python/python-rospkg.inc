DESCRIPTION = "ROS package library"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://src/rospkg/__init__.py;beginline=1;endline=31;md5=9cea8ac73441707f7779ae66adf75f62"
SRCNAME = "rospkg"

SRCREV = "75c3645eb1d38e61fd39ca414e86b26dbf4cce88"
ROS_BRANCH ?= "branch=master"
SRC_URI = "git://github.com/ros-infrastructure/rospkg;${ROS_BRANCH};protocol=https"

S = "${WORKDIR}/git"

RDEPENDS:${PN} += "${PYTHON_PN}-xml ${PYTHON_PN}-rosdep ${PYTHON_PN}-distro"

BBCLASSEXTEND = "native"
