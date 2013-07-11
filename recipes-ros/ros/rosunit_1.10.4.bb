DESCRIPTION = "Unit-testing package for ROS. This is a lower-level library for rostest and handles unit tests, whereas rostest handles integration tests."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

require ros.inc

SRC_URI += "file://0001-rosunit-extras.cmake.em-remove-NO_CMAKE_FIND_ROOT_PA.patch;striplevel=3"

S = "${WORKDIR}/ros-${PV}/tools/${BPN}"

BBCLASSEXTEND += "native"
