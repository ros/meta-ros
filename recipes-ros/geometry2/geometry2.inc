SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "94fbafe3e86b8b1e21a8d2a15f30d48a"
SRC_URI[sha256sum] = "f08f4002cfa8c83021e959176d6384e7c4669a8c5363546f27911103bca84232"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry2"
