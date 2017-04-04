DESCRIPTION = "This package allows you to publish the state of a robot to tf."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=5ee5b8b046ae48ad94a2037ca953a67b"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2315f637a70871bb460d6365a240741f"
SRC_URI[sha256sum] = "7b1321f8e26352c0fc8558ddabfc86897613ac16834fb83d8696ff7d6dd973b5"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

DEPENDS = "libeigen kdl-parser rosconsole roscpp rostime sensor-msgs tf tf-conversions"
