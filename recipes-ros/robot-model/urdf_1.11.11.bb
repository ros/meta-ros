DESCRIPTION = "This package contains a C++ parser for the Unified Robot Description Format (URDF), which is an XML format for representing a robot model. The code API of the parser has been through our review process and will remain backwards compatible in future releases."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rosconsole-bridge roscpp urdfdom-headers urdf-parser-plugin pluginlib urdfdom cmake-modules libtinyxml"

require robot-model.inc

SRC_URI += "file://0001-urdf-address-gcc6-build-error-and-tune-156.patch;striplevel=2"
