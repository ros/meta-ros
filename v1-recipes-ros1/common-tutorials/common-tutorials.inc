SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "4d124a7d874a00c622590f7a94d7d441"
SRC_URI[sha256sum] = "5c0b0dd964805f37720f404b6f2d7c455c237b76ab161b5192d0852a09b0114a"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "common_tutorials"
