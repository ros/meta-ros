SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "063484906d1c2f1a4ee961680e43b559"
SRC_URI[sha256sum] = "011b77bc33afea927bab2707ddda585df8de5f1fc6e387081f6bf1ea12d2323b"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry2"
