DESCRIPTION = "Integration test suite based on roslaunch that is compatible with xUnit frameworks."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost rosunit-native"

require ros-comm.inc

S = "${WORKDIR}/ros_comm-${PV}/tools/${BPN}"
