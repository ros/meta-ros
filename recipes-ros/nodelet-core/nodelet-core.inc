SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "043c4455172d2ec9cfb87385aa71dedc"
SRC_URI[sha256sum] = "f41b124b769bde2a1dd603001e8e03b8310706780856fdb1660921dd66716be5"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "nodelet_core"
