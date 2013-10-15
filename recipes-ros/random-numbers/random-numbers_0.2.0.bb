DESCRIPTION = "This library contains wrappers for generating floating point values, integers, quaternions using boost libraries."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost"

SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "762a686cce0624fb86dab0cdff392b3a"
SRC_URI[sha256sum] = "195cd67c87eab51ffbe73ff53e7c899e0c8a1f7064dfae3b325d6c23ff4b4003"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
