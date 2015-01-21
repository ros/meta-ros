SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "473df5475e5a289710ba476ceb6d37a5"
SRC_URI[sha256sum] = "1de48c8d8e5e22287b8be2fb51b470a5cba5d05f49ebbeaa6dfa01392f3d40ae"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "navigation"
