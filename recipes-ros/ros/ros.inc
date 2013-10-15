SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "980e5d737e31f230aba1b9c0abb5caaf"
SRC_URI[sha256sum] = "e877f9511fdc35e4dfe5f0de53132b305bb0dffad9f1d7afc9632d5aea57f420"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros"
