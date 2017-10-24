DESCRIPTION = "Provides nodes to convert messages from SocketCAN to a ROS Topic and vice versa."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "socketcan-interface can-msgs roscpp"
RDEPENDS_${PN} = "can-msgs"

require ros-canopen.inc
