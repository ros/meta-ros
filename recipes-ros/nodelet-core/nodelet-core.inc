SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "5f69378e8a187e6b5694d7d4582662c1"
SRC_URI[sha256sum] = "45f6382112bb8b5bad47ce18e12a95018a53e9cc3b08b5daad232f089569f8eb"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "nodelet_core"
