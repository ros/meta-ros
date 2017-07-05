SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "06835d9eefbfbcc0b575529de19f8e9b"
SRC_URI[sha256sum] = "ecc778090b9e404353c3afe42f88369d8593d2da11a4b39e68feca6d8a59279a"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros"
