SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "56ba29a3ac7810a1766f05ec0f7bdddd"
SRC_URI[sha256sum] = "3a0070ef49d890df81b23eca819857a257ab677d09a2533e5a9f833b969a8ce1"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "navigation"
