DESCRIPTION = "A collection of .mk include files for building ROS architectural elements."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = ""

require ros.inc

S = "${WORKDIR}/ros-${PV}/core/${BPN}"
