DESCRIPTION = "Underlying data libraries for roscpp messages"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "cpp-common roscpp-serialization roscpp-traits rostime"

require roscpp-core.inc

S = "${WORKDIR}/roscpp_core-${PV}/${ROS_BPN}"
