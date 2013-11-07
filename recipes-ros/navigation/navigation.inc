SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "cddadf97a28ccffe93c0d662639801d5"
SRC_URI[sha256sum] = "402f1800577d22a168882aa99754d99cfd0a54e9a02a1ec804c351cd327d7540"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "navigation"
