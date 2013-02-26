DESCRIPTION = "This is a set of tools for recording from and playing back to ROS \
topics.  It is intended to be high performance and avoids \
deserialization and reserialization of the messages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost bzip2 cpp-common python-imaging \
  rosconsole roscpp roscpp-serialization topic-tools \
  xmlrpcpp"

require ros-comm.inc

S = "${WORKDIR}/ros_comm-${PV}/tools/${BPN}"
