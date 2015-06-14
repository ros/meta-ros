DESCRIPTION = "The pluginlib package provides tools for writing and dynamically loading plugins \
using the ROS build infrastructure."
SECTION = "devel"
LICENSE = "BSD & BSL-1.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=10;md5=bbbb6ab628b1f3daee74dd9c62bee312"

DEPENDS = "boost class-loader rosconsole roslib libtinyxml"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2fffc63aed17307ad165a1dfa05a7190"
SRC_URI[sha256sum] = "239591f5eb263e48769942feb125c46a56ae3e226dc3ef4bf5dfa39ab94c47e1"

inherit catkin
