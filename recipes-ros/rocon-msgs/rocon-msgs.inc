SRC_URI = "https://github.com/robotics-in-concert/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9cf381dfbcddfd11a7237719b94c2250"
SRC_URI[sha256sum] = "47b7f4dcac0c260bcbe4428032968b4c52476bf37ac43be67bcda4cd1699fce0"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "rocon_msgs"
