DESCRIPTION = "Common-Lisp ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "genmsg"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "74ae3d474fe0d8c7d67f85039a6a0b57"
SRC_URI[sha256sum] = "cc170a66f92e17945168479974ba24ed6970e9f09eb555b0225a99d339e22a5a"

inherit catkin
