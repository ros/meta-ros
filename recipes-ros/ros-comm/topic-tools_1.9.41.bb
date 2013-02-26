DESCRIPTION = "rostopic contains the rostopic command-line tool for displaying debug information about \
ROS Topics, including publishers, subscribers, publishing rate, and ROS Messages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rostest"

require ros-comm.inc

S = "${WORKDIR}/ros_comm-${PV}/tools/${BPN}"
