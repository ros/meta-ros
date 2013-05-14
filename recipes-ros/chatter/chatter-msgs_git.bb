DESCRIPTION = "The chatter_msgs package"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = ""

SRC_URI = "git://github.com/bmwcarit/ros_chatter.git"

SRCREV = "${AUTOREV}"
PV = "1.0.0+gitr${SRCPV}"

S = "${WORKDIR}/git/chatter_msgs"

inherit catkin
