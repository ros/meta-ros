SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a2852ce1e1b3a7805f0a0836b8942811"
SRC_URI[sha256sum] = "908dee4ff9031a0f954f98f8c5b646c24efd86ec352887df4882b1b6e067c5b6"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "robot_model"
