SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "feb4e2d49ba8e4607524d4e91aeec4c9"
SRC_URI[sha256sum] = "6313abe64e29fbbe87d8e108c13ccd075de4ff8f01b85f988716b9475d312112"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "robot_model"
