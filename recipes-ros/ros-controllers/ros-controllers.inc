SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d374e14a091fecc8a90fa37c2995ccb4"
SRC_URI[sha256sum] = "5c41d8384aef03760d24fd7c23c17706dbd00c505561c91077a2b0b707062012"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_controllers"
