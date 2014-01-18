SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e396236e352fde3f961d04026621ec17"
SRC_URI[sha256sum] = "78c5dde9070597e6f581a354ca66ef60422b9e84f9e7ace81b7cfb4481db2208"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "nodelet_core"
