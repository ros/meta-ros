DESCRIPTION = "This package contains a C++ parser for the Collada robot description format."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=19;endline=19;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "collada-dom roscpp urdfdom-headers urdf urdf-parser-plugin class-loader"

require collada-urdf.inc
