SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "60b0e4fe9027f4de1d10765e57f62620"
SRC_URI[sha256sum] = "a076e1a148b136f856f1fdf48225458ec1f3d6cd405e153f81a5c388943dfb2e"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "robot_model"
