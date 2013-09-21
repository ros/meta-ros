DESCRIPTION = "The chatter_sender package"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "chatter-msgs roscpp"

SRC_URI = "git://github.com/bmwcarit/ros_chatter.git"
SRC_URI += "file://0001-rostest-is-optional.patch;striplevel=2"

SRCREV = "${AUTOREV}"
PV = "1.0.0+gitr${SRCPV}"

S = "${WORKDIR}/git/chatter_sender"

inherit catkin
