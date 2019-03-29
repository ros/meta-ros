SRC_URI = "https://github.com/stonier/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "78f4275f5c7cec759ca096e22d1570d2"
SRC_URI[sha256sum] = "358e9de2a31cf0df70e1b5d6e0d9dc5f00d042f1974c786eabbb7bcb48151477"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ecl_core"
