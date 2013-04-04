DESCRIPTION = "rostopic contains the rostopic command-line tool for displaying debug information about \
ROS Topics, including publishers, subscribers, publishing rate, and ROS Messages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=68b329da9893e34099c7d8ad5cb9c940"

DEPENDS = "rostest-native rostest roscpp"

require ros-comm.inc

S = "${WORKDIR}/ros_comm-${PV}/tools/${ROS_BPN}"
