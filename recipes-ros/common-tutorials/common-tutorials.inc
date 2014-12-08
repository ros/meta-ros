SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "5c8282a3d4b100bcdd2b6fd5e619f35a"
SRC_URI[sha256sum] = "5be04cdcfbc569d7b89c306628fd4414a3e2972ad2154548df2b86d4056393d9"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "common_tutorials"
