DESCRIPTION = "rosgraph contains the rosgraph command-line tool, which prints \
information about the ROS Computation Graph."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

RDEPENDS_${PN} = "python-xmlrpc python-threading python-rospkg rospy python-netifaces"

require ros-comm.inc

ROS_PKG_SUBDIR = "tools"
