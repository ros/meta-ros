SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2d4b8083abc6598857e01b698f4b0d20"
SRC_URI[sha256sum] = "44c5a076a604134e44d044e08b2c15b185aefac277b8632b5ca2d011ec8d3da6"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_comm"
