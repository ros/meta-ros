SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "fed77222934a550f51e82761a9ce118a"
SRC_URI[sha256sum] = "bb06f8cc300eb9d5695a4b0976c0f4bd906983df5fcda9126a5a20a24f5ce9a3"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "roscpp_core"
