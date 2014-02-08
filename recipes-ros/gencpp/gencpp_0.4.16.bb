DESCRIPTION = "C++ ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "genmsg"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "af642963cc6ff647f17550734047eab6"
SRC_URI[sha256sum] = "a13a543d2b8a272bc65c687aad210286cdbf1fb2253b2ca86d7b199d0a8e91bc"

inherit catkin
