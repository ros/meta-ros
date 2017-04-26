SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "405b17d70c464786d3fe7a73bf8f95b1"
SRC_URI[sha256sum] = "020b952e6c2fa8057ec878a07a290ac027f58108160bcbb0b37d6ddfa2e9ebf4"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "joystick_drivers"

