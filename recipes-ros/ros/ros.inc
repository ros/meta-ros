SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "405ed98cdab270f8aee47c4d885638c2"
SRC_URI[sha256sum] = "849172aa47f33f997272d2e5c17e1435b843db0eb05143decdcfbfd218a2dc42"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros"
