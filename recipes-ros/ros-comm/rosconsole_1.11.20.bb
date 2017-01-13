DESCRIPTION = "ROS console output library."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "apr boost cpp-common log4cxx rostime rosunit"

require ros-comm.inc

ROS_PKG_SUBDIR = "tools"

SRC_URI += "file://0001-Add-Include-vector-to-fix-building-on-GCC-6.patch;striplevel=3"
