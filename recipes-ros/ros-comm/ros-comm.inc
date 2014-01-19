SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "22c0dfbf60d3e4f77e253bb56d75c00c"
SRC_URI[sha256sum] = "693635e84d2a0cb0074c799fce78c474af2870b37e6805073b99a888e650fca4"

SRC_URI += "file://0001-rostest-is-optional.patch;patchdir=../.."

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_comm"
