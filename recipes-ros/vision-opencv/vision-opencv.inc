SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1b749d8c3e78bc2e89e08fcdadfab223"
SRC_URI[sha256sum] = "1c65690c8c061f8029b33c5850696a793420229fe0bb095361b78db370445513"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "vision_opencv"
