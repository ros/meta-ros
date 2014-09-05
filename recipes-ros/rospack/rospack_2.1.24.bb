DESCRIPTION = "ROS Package Tool"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost python-rospkg-native libtinyxml"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d625279380f40e8033eeeb451f0e4b5b"
SRC_URI[sha256sum] = "95e05ef70eb46e483c241278e9c0d7fb10390a61927c2593ce6f408682e1637d"

inherit catkin

RDEPENDS_${PN} = "python-rosdep python-subprocess"
