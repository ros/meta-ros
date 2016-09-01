DESCRIPTION = "The pluginlib package provides tools for writing and dynamically loading plugins \
using the ROS build infrastructure."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost class-loader rosconsole roslib libtinyxml"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6fb641ba2a31737e38d1535bbdf37a07"
SRC_URI[sha256sum] = "fca9f2f449ac7fea4eb4597d5ac8ac77d572f18f890333abd4cd2bbc0249f117"

inherit catkin
