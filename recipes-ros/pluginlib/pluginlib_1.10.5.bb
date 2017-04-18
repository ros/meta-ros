DESCRIPTION = "The pluginlib package provides tools for writing and dynamically loading plugins \
using the ROS build infrastructure."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost class-loader rosconsole roslib libtinyxml"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "eb443817a26dc03b7c063e9bbb82439f"
SRC_URI[sha256sum] = "53a0ccb7a4654d464271189fc44ba23d6be8d3ecdfb40506b9d9fb4a87f19d6c"

inherit catkin
