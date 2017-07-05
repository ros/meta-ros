DESCRIPTION = "This package defines messages commonly used in mapping packages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=a3ae2ba3f0f44e61270955e8cd98afcf"

DEPENDS = "message-generation std-msgs sensor-msgs nav-msgs"

SRC_URI = "https://github.com/ethz-asl/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e5c02300154e594800f4093f441c1740"
SRC_URI[sha256sum] = "d137fb17883a67c2bd6cc552c288d1b32b2300c532d0120473d0e020d109535d"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
