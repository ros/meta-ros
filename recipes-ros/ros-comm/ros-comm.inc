SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "cbffa78ad51f76f0b81bb0e9a82b5de6"
SRC_URI[sha256sum] = "b8f48c57d58b623c0b9828476fd8fc785570238d1e117fddaae9aaf8600915d3"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_comm"
