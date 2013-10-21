SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2d0c73bbdb8a992466c9066ac9285778"
SRC_URI[sha256sum] = "4fd5a14cfac4283196b99a29728490f30c34392bf157761fdc0ff1deb8df9792"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros"
