DESCRIPTION = "This library provides a standardized interface for processing data as a sequence of filters."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roslib rosconsole roscpp pluginlib"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "93b0685f061351dd2169f6b7f5373ca6"
SRC_URI[sha256sum] = "6632c8bc2f3c47db6f69d136ccf58a1963ac0c83f5f542173caaebd2c7086160"

inherit catkin
