DESCRIPTION = "XmlRpc++ is a C++ implementation of the XML-RPC protocol. This version is heavily \
modified from the package available on SourceForge in order to support roscpp's threading model. \
As such, we are maintaining our own fork."
SECTION = "devel"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=184dd1523b9a109aead3fbbe0b4262e0"

DEPENDS = "cpp-common"

require ros-comm.inc

ROS_PKG_SUBDIR = "utilities"
