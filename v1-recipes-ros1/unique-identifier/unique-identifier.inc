SRC_URI = "https://github.com/ros-geographic-info/${ROS_SPN}/archive/${ROS_SPN}-${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6c04f7238aae651cfb3daa97c018232d"
SRC_URI[sha256sum] = "70f3fc1e8b81ce2a80383fe1bec69dd0760913852a78ff1d010e6a1c2baa1d3c"

S = "${WORKDIR}/${ROS_SPN}-${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "unique_identifier"
