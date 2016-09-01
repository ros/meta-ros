SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "83719b720e925860d0804978fdb75eac"
SRC_URI[sha256sum] = "9432422b56a586828e75ec038f5400c3a92b0b108dd42bc331d8160972df012c"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "nodelet_core"
