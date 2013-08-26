DESCRIPTION = "Common-Lisp ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "genmsg-native"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "58b049b28c98c6e3456dd5b422c1d1f9"
SRC_URI[sha256sum] = "b40b6c2df3e70e540ed5b27657a3b772268525a1c7819b87e145f637fd5d4d44"

inherit catkin
