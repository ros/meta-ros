SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8408e5b990d157d1d30e56cc0a1ec28c"
SRC_URI[sha256sum] = "72374d3c43a2715a743365be186fddd23f016889430b5da1209f5bcaba08d141"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "robot_model"
