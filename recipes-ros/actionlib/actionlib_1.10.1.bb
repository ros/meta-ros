DESCRIPTION = "The actionlib stack provides a standardized interface for \
  interfacing with preemptable tasks."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "actionlib-msgs roscpp rostest"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8da88314483b1330906b0ecf89c33494"
SRC_URI[sha256sum] = "c76317f60afec9e4cdcce28e0b88b9aef7e355ba8295228e759aa914ed10aae4"

SRC_URI += "https://github.com/ros/${ROS_SPN}/commit/f066ff531ecdea3b859881aa1f4b4b34cba910c1.patch;name=patch"
SRC_URI[patch.md5sum] = "ba32239ddb0c6837a4296119dda5f08a"
SRC_URI[patch.sha256sum] = "d07e4cd0982fee417f574acac4e2e2a0387188bf254c6f49f7ab0f8c206082b8"

inherit catkin
