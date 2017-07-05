SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9659e0b3e37108a78f3353ce55cee98e"
SRC_URI[sha256sum] = "9cd6f439e55195b482b9702369514dde25865a256f3059eb7f475da7ddd483d6"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "diagnostics"
