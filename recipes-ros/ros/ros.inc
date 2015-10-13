SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9660980c9162442d867c440f7686f322"
SRC_URI[sha256sum] = "8a85cab20a9de8969fc00dd8f6d5b193876ff1d31104e345806a2d8a0e2d0cd9"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros"
