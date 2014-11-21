SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "58d4b8a8d98120bb3a46cee07168287d"
SRC_URI[sha256sum] = "48f841a2a4f048d08149488028289da8b8374a2aab91c5e2c628300a574cac37"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_control"
