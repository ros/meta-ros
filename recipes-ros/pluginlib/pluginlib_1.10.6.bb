DESCRIPTION = "The pluginlib package provides tools for writing and dynamically loading plugins \
using the ROS build infrastructure."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost class-loader rosconsole roslib libtinyxml"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "aa975b5a290de5e4fb2e86e234b686c0"
SRC_URI[sha256sum] = "af7ac0e0aa77b6b1ff2f781482fe30e31cafd1087b708d0f1c2a51176c585614"

inherit catkin
