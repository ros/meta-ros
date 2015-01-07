SRC_URI = "git://github.com/hbrobotics/${ROS_SPN}.git;protocol=https;branch=hydro-devel"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_arduino_bridge"
