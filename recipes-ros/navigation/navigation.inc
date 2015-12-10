SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f5a33aa3213c628ba1149040ce36b130"
SRC_URI[sha256sum] = "d26e2962a1391bc5921316fbdbd5c6e2712f86215ee0a98fe9bf2d9bad601339"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "navigation"
