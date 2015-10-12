SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "fe069a7148f1744cb5e4b1c745996443"
SRC_URI[sha256sum] = "781a0510136a820d217862f7491183b3deeadaf18aa0fabeb28d79e365510e12"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "robot_model"
