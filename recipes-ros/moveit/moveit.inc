SRC_URI = "git://github.com/ros-planning/${ROS_SPN}.git;branch=indigo-devel;protocol=git"
SRCREV = "901e66c1319a3e7ee0e0879898b8d5fa865563c3"

S = "${WORKDIR}/git/${ROS_BPN}"

inherit catkin ros-insane

ROS_SPN = "moveit"
