SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "65bc1bebb9d963974ba9c64e3fddee51"
SRC_URI[sha256sum] = "e8937cea7d5c7e13adc090396039377a756b40b318887c758c4414f318265912"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros"
