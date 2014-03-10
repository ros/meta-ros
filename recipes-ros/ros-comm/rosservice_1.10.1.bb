DESCRIPTION = "rosservice contains the rosservice command-line tool for listing and querying ROS Services."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

require ros-comm.inc

ROS_PKG_SUBDIR = "tools"

RDEPENDS_${PN} = "rosmsg"
