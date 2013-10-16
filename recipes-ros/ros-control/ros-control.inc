SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "59f1d09911db89c046e255a1597dfeff"
SRC_URI[sha256sum] = "7d913be4c4cba6a19c24e8327ed23cc3afe6d32f63650439aa96dfea14a291e5"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_control"
