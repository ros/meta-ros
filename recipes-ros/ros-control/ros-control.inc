SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "37bbc1ebafa87806918bf8123db48d18"
SRC_URI[sha256sum] = "edf1a63e6ec8bf26773896bf7c73883e8fb025a612d60217bedd5ac5cf14b434"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_control"
