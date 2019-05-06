DESCRIPTION = "Standard ROS Messages including common message types representing primitive data types and other basic message constructs, such as multiarrays. \
    For common, generic robot-specific message types, please see common_msgs."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "message-generation message-runtime"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1cbde9a04225a6fb668465c7554ed4a2"
SRC_URI[sha256sum] = "c837974f840f42d75687360b0b4e40462c0abf4c94ce7fe227a1941272393f80"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
