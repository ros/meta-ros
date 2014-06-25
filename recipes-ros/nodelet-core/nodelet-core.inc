SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "cd0d8199e42ba1d53280c00e528f1ec3"
SRC_URI[sha256sum] = "c4eb43f05c7bc26ed99d8e2873f3cc700374a49b7fc4732a32a6fb5abb8cdd13"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "nodelet_core"
