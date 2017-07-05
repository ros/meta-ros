DESCRIPTION = "The URDF (U-Robot Description Format) library provides core \
data structures and a simple XML parsers for populating the class data \
structures from an URDF file."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b441202ba2d6b14d62026cb18bb960ed"

DEPENDS = "urdfdom-headers console-bridge libtinyxml"

require urdfdom.inc

S = "${WORKDIR}/${ROS_SP}"

inherit cmake ros
