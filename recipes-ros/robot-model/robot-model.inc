SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "5867e22cea9db638689102a544010974"
SRC_URI[sha256sum] = "da70be8a4d70737880c98402cc5beee008e617e1e60e46b2b59d598376525c48"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "robot_model"
