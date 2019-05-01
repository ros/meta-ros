DESCRIPTION = "rospy is a pure Python client library for ROS. The rospy client API enables Python \
programmers to quickly interface with ROS Topics, Services, and Parameters."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=23;endline=23;md5=d566ef916e9dedc494f5f793a6690ba5"

RDEPENDS_${PN} = "std-msgs genpy ${PYTHON_PN}-logging ${PYTHON_PN}-pyyaml rosgraph roslib rosgraph-msgs roscpp"

require ros-comm.inc

ROS_PKG_SUBDIR = "clients"
