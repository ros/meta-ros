SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "823b571ac861a0c5bf41af103570c97c"
SRC_URI[sha256sum] = "e7c045b95a28e0f125a01bc79da0335d5cdf19d52c2c1814587c8c8a943e2e34"

SRC_URI += "file://0001-rostest-is-optional.patch;patchdir=../.."

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_comm"
