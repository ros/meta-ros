SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "dce7f2003e60fc8d29f8a012a5d6ed1b"
SRC_URI[sha256sum] = "7c4ade380aa33d8c39d446185a715e08494115097cd34fb8e28dba53b29b7966"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "navigation"
