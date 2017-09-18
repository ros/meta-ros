DESCRIPTION = "This package contains a C++ parser for the Unified Robot Description Format (URDF)"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rosconsole-bridge roscpp urdfdom-headers urdf-parser-plugin pluginlib urdfdom cmake-modules libtinyxml class-loader"

require robot-model.inc
