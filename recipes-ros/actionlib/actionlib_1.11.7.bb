DESCRIPTION = "The actionlib stack provides a standardized interface for interfacing with \
preemptable tasks."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "actionlib-msgs roscpp"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "27f247adad8441c2ac2316cfc4ce4427"
SRC_URI[sha256sum] = "e849e30363b7df0a92ec9179b9ff9833a72581003da9eb880fc3e21ef1f4667e"

inherit catkin
