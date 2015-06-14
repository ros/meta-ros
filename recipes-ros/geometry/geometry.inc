SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "5c09987b0185183d54522e92bf64d6f3"
SRC_URI[sha256sum] = "fbfbc707d239a76f7258372cb73a78341c0433d990d6f053340417c5ecb84231"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry"
