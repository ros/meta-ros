SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "16086ecc45a0b07468fad92da21af423"
SRC_URI[sha256sum] = "19a44ac53f878b10cfbfa6cbd80eadbb351dc70697c91f52177b3c1663b7ac69"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_comm"
