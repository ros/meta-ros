DESCRIPTION = "The pluginlib package provides tools for writing and dynamically \
  loading plugins using the ROS build infrastructure."
SECTION = "devel"
LICENSE = "BSD & BSL-1.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=10;md5=bbbb6ab628b1f3daee74dd9c62bee312"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "681c98bb532cbd663f56f59590dcdae5"
SRC_URI[sha256sum] = "096112e2e5063bfca583bfa4ba3e3f47b51befd5e4b6c3edcc8311986b39a70f"

DEPENDS = "boost class-loader rosconsole roslib libtinyxml"

inherit catkin
