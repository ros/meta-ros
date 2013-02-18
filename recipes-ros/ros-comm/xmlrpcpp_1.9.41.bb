DESCRIPTION = \
  "XmlRpc++ is a C++ implementation of the XML-RPC protocol. This version is \
    heavily modified from the package available on SourceForge in order to \
    support roscpp's threading model. As such, we are maintaining our \
    own fork."
SECTION = "devel"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=46ee8693f40a89a31023e97ae17ecf19"

DEPENDS = "cpp-common"

require ros-comm.inc

S = "${WORKDIR}/ros_comm-${PV}/utilities/${BPN}"
