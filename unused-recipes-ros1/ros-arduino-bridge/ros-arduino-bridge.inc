SRC_URI = "git://github.com/hbrobotics/${ROS_SPN}.git;protocol=https;branch=hydro-devel"
SRCREV = "4f45c3467d724cd7a25db3445f4c98dc759e8fd0"

S = "${WORKDIR}/git/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_arduino_bridge"
