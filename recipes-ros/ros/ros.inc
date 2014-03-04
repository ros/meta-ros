SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "db55e35ae20609cdc2f874ceabf370af"
SRC_URI[sha256sum] = "1ae5886a54519c500669c98c9832f02d84f259d3ddb6a30fb78c6bb42b2b3a94"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros"
