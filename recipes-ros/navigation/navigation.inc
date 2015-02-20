SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "441a198ab3223e1cd65df1a74a2520ef"
SRC_URI[sha256sum] = "747c527c0f7ce880548be81203eab3cb5022e928ca57f672a7a39107cb249c01"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "navigation"
