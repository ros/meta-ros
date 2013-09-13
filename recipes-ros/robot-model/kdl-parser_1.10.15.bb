DESCRIPTION = "The Kinematics and Dynamics Library (KDL) defines a tree structure to represent the kinematic and dynamic parameters of a robot mechanism. <tt>kdl_parser</tt> provides tools to construct a KDL tree from an XML robot representation in URDF."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "orocos-kdl urdf rosconsole"

require robot-model.inc
