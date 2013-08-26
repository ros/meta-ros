DESCRIPTION = "Standard ROS Messages including common message types representing primitive data types and other basic message constructs, such as multiarrays. \
    For common, generic robot-specific message types, please see common_msgs."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "message-generation-native message-runtime-native"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "5382be6760984ea6818858cd6f6ccf04"
SRC_URI[sha256sum] = "c9a0008c70d3383979de6e1733a730d62aaaf4c3e15e8f20873816d8013cea6c"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
