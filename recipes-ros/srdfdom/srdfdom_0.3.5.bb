DESCRIPTION = "Parser for Semantic Robot Description Format"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cmake-modules boost urdf urdfdom-py console-bridge libtinyxml urdfdom-headers"

SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz \
           file://0001-address-gcc6-build-error.patch \
           "
SRC_URI[md5sum] = "1b35fc7d120a8dbf41ede3c03c88ca5e"
SRC_URI[sha256sum] = "9018c7c4da88e406e5059f0e2013049dfa4c04980f42a311c1201748ba5ba1de"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

ROS_SPN = "srdfdom"
