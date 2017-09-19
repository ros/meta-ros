SRC_URI = "git://github.com/ros-planning/${ROS_SPN}.git;branch=indigo-devel;protocol=git"
SRCREV = "820657a985dd492edb9bfee207e864f378329b60"

S = "${WORKDIR}/git/${ROS_BPN}"

inherit catkin ros-insane

ROS_SPN = "moveit"
