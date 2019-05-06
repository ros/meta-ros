DESCRIPTION = "A Python-based implementation of the ROS serial protocol."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

require rosserial.inc

RDEPENDS_${PN} = "rosserial-msgs diagnostic-msgs ${PYTHON_PN}-pyserial"
