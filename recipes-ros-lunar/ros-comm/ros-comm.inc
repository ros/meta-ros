SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7f731bf38da6099d1d7b0083b568836b"
SRC_URI[sha256sum] = "fbfbecbdbd3c0fb752c5757aac843cc9bfffe71ac7b1b094e2d1142567f02fa1"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_comm"
