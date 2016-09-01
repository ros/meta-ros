SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6ab08e73ad24e1b67381c42c7f78165c"
SRC_URI[sha256sum] = "be7af9ee617f5a427782d0bd0bdc93d665610c8e7a9329d3089dee1be99fffef"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros"
