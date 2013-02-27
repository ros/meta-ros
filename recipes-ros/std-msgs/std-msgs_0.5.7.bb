DESCRIPTION = "Standard ROS Messages including common message types representing primitive data types and other basic message constructs, such as multiarrays. \
    For common, generic robot-specific message types, please see common_msgs."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "message-generation genlisp genpy"

SRC_URI = "https://github.com/ros/${ROS_BPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_BP}.tar.gz"
SRC_URI[md5sum] = "ea40e6dd8ea19fe54a2b476358c0ceea"
SRC_URI[sha256sum] = "acc3d6aed8ede795e4bc6676c1849924699a418769b3d29016a9a2ac08319a56"

S = "${WORKDIR}/${ROS_BPN}-${PV}"

inherit catkin
