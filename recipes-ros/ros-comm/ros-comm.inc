SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a03bda14346ecc015810e0b2ad923ce2"
SRC_URI[sha256sum] = "435eed0fc8f7df46fe12097131e1518730f13fbbe3820d590017bddcbf3d8871"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_comm"
