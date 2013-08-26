SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "0055265f3854afcf4cc0abff06a9f023"
SRC_URI[sha256sum] = "257f45f36463d5ffc04e1d60ac1fc6a2e7c1b11d012daa43b2eb43001383048c"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "common_tutorials"
