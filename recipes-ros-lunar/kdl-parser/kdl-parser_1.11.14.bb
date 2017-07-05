DESCRIPTION = "kdl_parser provides tools to construct a KDL tree from an XML robot representation in URDF."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "libeigen orocos-kdl rosconsole roscpp urdf cmake-modules"

require kdl-parser.inc

SRC_URI += "file://0001-add-explicit-dependency-on-libeigen.patch"
