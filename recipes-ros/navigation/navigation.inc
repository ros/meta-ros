SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "fdffc9ca86cbb1f05817dd2d4952d41d"
SRC_URI[sha256sum] = "430f7bf21c030dabc5d30eb5fd7a1794a1606b9a94c573fa1f27d4ce8f49dce5"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "navigation"
