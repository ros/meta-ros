DESCRIPTION = "The actionlib stack provides a standardized interface for \
  interfacing with preemptable tasks."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "actionlib-msgs roscpp rostest"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8da88314483b1330906b0ecf89c33494"
SRC_URI[sha256sum] = "c76317f60afec9e4cdcce28e0b88b9aef7e355ba8295228e759aa914ed10aae4"

SRC_URI += "file://0001-check-for-CATKIN_ENABLE_TESTING.patch"

inherit catkin
