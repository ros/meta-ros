SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "bffda0ae65f2813a9ef908ec4f3ec26b"
SRC_URI[sha256sum] = "fdf498d4e1acd9e0cb7c00abe201af993bbbf82e83ca4c5c9fc9a0ac73a62f91"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_controllers"
