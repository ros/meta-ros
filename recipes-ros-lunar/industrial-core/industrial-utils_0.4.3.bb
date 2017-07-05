DESCRIPTION = "Industrial utils is a library package that captures common funcitonality for the ROS-Industrial distribution"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp urdf"

require industrial-core.inc

SRC_URI += "file://0001-utils-build-unit-tests-conditionally.patch"
