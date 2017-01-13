DESCRIPTION = "The Kinematics and Dynamics Library (KDL) defines a tree structure to represent the kinematic and dynamic parameters of a robot mechanism. kdl_parser provides tools to construct a KDL tree from an XML robot representation in URDF."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "libeigen orocos-kdl rosconsole roscpp urdf cmake-modules"

require robot-model.inc
