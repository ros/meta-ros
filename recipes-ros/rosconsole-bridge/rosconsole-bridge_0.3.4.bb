DESCRIPTION = "Pipes console_bridge output to rosconsole/rosout when console_bridge is used in a ROS-dependent package"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rosconsole console-bridge"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d847f18aa69b913f52489bb238281ee0"
SRC_URI[sha256sum] = "3fc09e575f41d33ee31e1e4392ed09b8fed549634478e5d7176818479e9216dc"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
