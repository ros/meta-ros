SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f5e00ace1447819774d72be99bf09989"
SRC_URI[sha256sum] = "a32eea3dc00f80b3ba0d525e44073389a3569ae7a5250eab26ee8f0a623ffd2a"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry"
