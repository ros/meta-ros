SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d118f808d98a97c8f1fe215c8b8a891a"
SRC_URI[sha256sum] = "ec14b89bb0e9d142b715c04cf1619b43358f271ffd79ee8b3d0a46174aa0832d"

ROS_PKG_SUBDIR ?= ""
S = "${WORKDIR}/${ROS_SP}/${ROS_PKG_SUBDIR}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros"
