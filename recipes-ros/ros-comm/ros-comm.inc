SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "cad698f12fab7e0786e2e1355fa22cf7"
SRC_URI[sha256sum] = "bb687aa0f10aa8a87e42d1592b534bc602f5923f90bffdf51031f59c4bfe362a"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_comm"
