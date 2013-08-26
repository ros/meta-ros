SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "fea2c22bff4933de722b67cc226c899a"
SRC_URI[sha256sum] = "41aaadd0bb2378bae9a788839431546cfccc9f6b4cd8fc34684da1bb3d4356e1"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "nodelet_core"
