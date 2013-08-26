SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "084abed026cfe1821b03cfcfc4cc4c17"
SRC_URI[sha256sum] = "881f30e896c818502212762dda23bfd82ba384a4ec47d682f4f5fbe97b298cbc"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_comm"
