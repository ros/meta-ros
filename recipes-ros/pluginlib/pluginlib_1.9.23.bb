DESCRIPTION = "\
The pluginlib package provides tools for writing and dynamically loading plugins using the ROS build infrastructure.\
To work, these tools require plugin providers to register their plugins in the package.xml of their package.\
"
SECTION = "devel"
LICENSE = "BSD & BSL-1.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=10;md5=bbbb6ab628b1f3daee74dd9c62bee312"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "0d7ff6323e6d2122a624463aac94d5d5"
SRC_URI[sha256sum] = "eea71175bce307c495717ff51b793a189b5d19d7be8c564bf2ba6989dbc2c619"

DEPENDS = "boost class-loader rosconsole roslib libtinyxml"

inherit catkin
