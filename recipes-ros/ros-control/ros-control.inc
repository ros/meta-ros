SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f4d2b3a25817bfd988ac27bcf7ac8876"
SRC_URI[sha256sum] = "49d869d75ecaa76fecc27bbe043636bbb185d9bb65a1d454e68e77cec9ee1744"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_control"
