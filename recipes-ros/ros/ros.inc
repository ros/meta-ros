SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "4f7cdc30324cbc8fdf9309e2d3d7b08c"
SRC_URI[sha256sum] = "8d9c18dc6483961f03a98982df066cf7db4779f80d0299acbbedf14076f14ed2"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros"
