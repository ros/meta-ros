DESCRIPTION = "A set of message filters which take in messages and may output those messages at a later time, based on the conditions that filter needs met."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost rosconsole roscpp xmlrpcpp"

require ros-comm.inc

ROS_PKG_SUBDIR = "utilities"
