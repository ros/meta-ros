SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d0caa025030e711ba99c2e31c55c368f"
SRC_URI[sha256sum] = "85bcaeb7767c1c71bb91c78b9cfc3f8804a608c752cd8352cdfdca3d02a094ae"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "rosserial"
