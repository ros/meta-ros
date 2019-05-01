SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "de82a1a73648f4bfbe46e2428dc61df9"
SRC_URI[sha256sum] = "b179c57ad04e4c54ea80acf66dfd0d801185785e97e0f21a2c0ed2e6f897bc39"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_controllers"
