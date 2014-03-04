SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "5599c0d4f1846de30072836bc8279001"
SRC_URI[sha256sum] = "e46805ee5daa301e42028007b49e19a11846769dce5718f88a576eb7755eba38"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "freenect_stack"
