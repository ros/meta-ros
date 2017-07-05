SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b453b5d5bb06ebfca393d9e8e3c845e2"
SRC_URI[sha256sum] = "50b8b3c01b577c8d71c92ec64ae516e030e2912bc5afcf66b2ada8bc39002544"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "nodelet_core"
