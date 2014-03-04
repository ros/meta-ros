DESCRIPTION = "The URDF (U-Robot Description Format) library provides core \
data structures and a simple XML parsers for populating the class data \
structures from an URDF file."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b441202ba2d6b14d62026cb18bb960ed"

DEPENDS = "urdfdom-headers console-bridge libtinyxml"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d9e2b630313e458c92ee7f5a40ca4a74"
SRC_URI[sha256sum] = "e200f5adefa6bf8304e56ab8a3e1c04d3b6cced5df472f4aeb430ff81f1ffa0d"

S = "${WORKDIR}/${ROS_SP}"

inherit ros cmake
