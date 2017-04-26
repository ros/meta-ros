SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "137cf14d945df2a08bf963ead8eefd4c"
SRC_URI[sha256sum] = "9b3bc5363e026f55116fc85b806a93a23d1fcfd761922400dd7e13bcad94d5b0"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "roscpp_core"
