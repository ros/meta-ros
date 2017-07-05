SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "30bae34f87f4dc05f10c0a5f68335736"
SRC_URI[sha256sum] = "7bb9f57ea9e6c5fb0599b247736f4f3b7868d722344fb42bc3055b31626ea250"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_comm_msgs"
