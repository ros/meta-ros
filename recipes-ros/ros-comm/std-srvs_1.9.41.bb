DESCRIPTION = "Common service definitions. Currently just the 'Empty' service."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "message-generation-native message-runtime-native"

require ros-comm.inc

S = "${WORKDIR}/ros_comm-${PV}/messages/${ROS_BPN}"
