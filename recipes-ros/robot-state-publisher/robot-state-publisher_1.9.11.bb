DESCRIPTION = "This package allows you to publish the state of a robot to tf."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "libeigen kdl-parser rosconsole roscpp rostime sensor-msgs tf tf-conversions"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "79157d107c6062bb98ee8197d7db607c"
SRC_URI[sha256sum] = "d4cddab199fa32c423cc9ea0c532b564e1df751d5d3382a82e6054c9656cfae6"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
