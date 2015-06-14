SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "345b542c6c4dbfd5e6f588bc1f6db3e6"
SRC_URI[sha256sum] = "056e9a26962f249ad81461153fa1103dd363e66166f6ac245c41c8b7149375fe"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "nodelet_core"
