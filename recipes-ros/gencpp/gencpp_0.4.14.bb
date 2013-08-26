DESCRIPTION = "C++ ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "genmsg-native"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "56f32da469434f1a2ca28fc8aa3d8eb5"
SRC_URI[sha256sum] = "029742b10f4fb981d8ceef8ae440f50e2ac8670eb9901b7c70e76d933d7f07c2"

inherit catkin
