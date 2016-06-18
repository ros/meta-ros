SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "fc545639c01a2bc7e15259353c7a93c7"
SRC_URI[sha256sum] = "f860b87db6bd282d3b9f46d207938481ed1c748eb81a0160052571da6e477790"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros"
