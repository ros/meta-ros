DESCRIPTION = "C++ ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "genmsg"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "409006f065c6d4993734aec7efcbc180"
SRC_URI[sha256sum] = "0959b1dee8682a30a97fedbebfa2dd04ca4de598f215626b873cb0b7ad1dfd14"

inherit catkin
