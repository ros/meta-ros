DESCRIPTION = "rosnode is a command-line tool for displaying debug information \
about ROS Nodes, including publications, subscriptions and connections."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

RDEPENDS_${PN} = "python-io python-xmlrpc rosgraph rostopic"

require ros-comm.inc

ROS_PKG_SUBDIR = "tools"
