DESCRIPTION = "This package contains a set of tools that can be used from \
a hard realtime thread, without breaking the realtime behavior. The tools \
currently only provides the realtime publisher, which makes it possible \
to publish messages to a ROS topic from a realtime thread."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp rospy"

SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "21603474b7acc0d10204a3d8cf4f1247"
SRC_URI[sha256sum] = "8f9ba638f78026794a6e01d614f78dc2e4de19c9988fb308197608aa6ff7bf23"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
