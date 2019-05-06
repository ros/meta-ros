SRC_URI = "https://github.com/yujinrobot/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "47c5451f1f0db1dd980c2e804b78a285"
SRC_URI[sha256sum] = "d0b51e309d57852fc63a63b4070031857515eff1e9f7693df174f134ef4f049e"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "kobuki"
