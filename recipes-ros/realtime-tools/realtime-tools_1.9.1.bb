DESCRIPTION = "This package contains a set of tools that can be used from \
a hard realtime thread, without breaking the realtime behavior. The tools \
currently only provides the realtime publisher, which makes it possible \
to publish messages to a ROS topic from a realtime thread."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp rospy"

SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e8bc48641b124f9a5d704c28f395754b"
SRC_URI[sha256sum] = "1de97577326d4f87932eec94b4a46587c20f8989a69997ef613a0a79c375da2d"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
