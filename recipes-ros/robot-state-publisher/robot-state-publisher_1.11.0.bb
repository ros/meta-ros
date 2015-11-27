DESCRIPTION = "This package allows you to publish the state of a robot to tf."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=18;endline=18;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cmake-modules libeigen kdl-parser orocos-kdl rosconsole roscpp rostime sensor-msgs tf tf2-ros tf2-kdl"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "424e1489a03e3c071b46f63f39b4c6d0"
SRC_URI[sha256sum] = "c3ba1de7d5bd3b21ac3a2c4450e4de7c88967da4205b7d2f0c4a667011102ba9"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
