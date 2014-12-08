DESCRIPTION = " This package contains a C++ parser for the Collada robot \
description format. The parser reads a Collada XML robot description, and \
creates a C++ URDF model. Although it is possible to directly use this \
parser when working with Collada robot descriptions, the preferred user \
API is found in the urdf package."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "collada-dom roscpp urdfdom-headers urdf-parser-plugin class-loader"

require robot-model.inc
