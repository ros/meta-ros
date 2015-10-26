SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1a6962c3f3631c407502cdc5a68029fe"
SRC_URI[sha256sum] = "532b8cc764e9ca8765484a4468b8537c1ddd84342896267cf3e9f6b19c1b7203"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_comm"
