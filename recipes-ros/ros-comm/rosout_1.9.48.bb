DESCRIPTION = "System-wide logging mechanism for messages sent to the /rosout topic."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "log4cxx roscpp rosgraph-msgs"

require ros-comm.inc

ROS_PKG_SUBDIR = "tools"
