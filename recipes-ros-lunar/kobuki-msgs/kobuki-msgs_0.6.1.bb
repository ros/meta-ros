DESCRIPTION = "Kobuki message and service types: custom messages and services for Kobuki packages."
AUTHOR = "Daniel Stonier"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "std-msgs actionlib-msgs message-generation"

SRC_URI = "https://github.com/yujinrobot/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9a2ebd9de77d546636027b9ddeb5dd84"
SRC_URI[sha256sum] = "e8814159bec34b707936c69d06ca68eef02b5859f449b3c917ec236bf44cfaf9"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
