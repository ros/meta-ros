SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "43ca2b86d3617ead29bd1c4f1c8d496d"
SRC_URI[sha256sum] = "dfe0e512714d3b42c1d1e0f5b1389c8b77d7abfcea0f87a701753bbe2f917bbc"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "navigation"
