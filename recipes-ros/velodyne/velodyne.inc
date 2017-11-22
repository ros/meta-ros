SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${ROS_SP}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f832dfb305fc68cc4214c706cc53428d"
SRC_URI[sha256sum] = "7adfb3efaf89a6576f796e40ef32041175e911589cfc75cbf6d10e62fd66c3c2"

S = "${WORKDIR}/${ROS_SPN}-${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "velodyne"
