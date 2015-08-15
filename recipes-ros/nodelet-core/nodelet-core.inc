SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ccc4405905b046859f125d61e14598de"
SRC_URI[sha256sum] = "26256ff83c92db88b941e5d85ab2162fbcaa0f19ea066732c2de83255eed0001"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "nodelet_core"
