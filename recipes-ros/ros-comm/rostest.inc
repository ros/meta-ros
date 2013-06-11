DESCRIPTION = "Integration test suite based on roslaunch that is compatible with xUnit frameworks."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

require ros-comm.inc

BBCLASSEXTEND = ""

S = "${WORKDIR}/ros_comm-${PV}/tools/${BPN}"
