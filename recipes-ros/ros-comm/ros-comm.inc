SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f4e7a8d3f5bae348a52363ac269ebb6c"
SRC_URI[sha256sum] = "dbfe0bef76549d8615ea1e224ae471390ab88cddf7e78c41a38598e86194a302"

SRC_URI += "file://0001-rostest-is-optional.patch;patchdir=../.."
SRC_URI[md5sum] = "c6ae46a570278bde790c5a5b951e12e5"
SRC_URI[sha256sum] = "8303c26f2a5c7926dc1fc181a4e67868109c6379037135c21aa15f9be0cd0229"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_comm"
