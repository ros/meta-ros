DESCRIPTION = "This package contains a set of tools that can be used from a hard \
realtime thread, without breaking the realtime behavior.  The tools currently \
only provides the realtime publisher, which makes it possible to publish \
messages to a ROS topic from a realtime thread."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp rospy"

SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "67d1b158799c48c24632f875bfec4e5e"
SRC_URI[sha256sum] = "75d1c0c2b7a5650e2a08f6b131b3a84d383f5094a6603847df37f1680c1a4315"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
