DESCRIPTION = "This package contains a number of URDF tutorials."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "urdf"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b8be1589ce7779f43f8de30cee725c52"
SRC_URI[sha256sum] = "c54a8967ff9fdab1fd3a8cd42994e874b0d332e186338e78381317ebae118b92"

S = "${WORKDIR}/${ROS_SP}/${ROS_SPN}"

inherit catkin
