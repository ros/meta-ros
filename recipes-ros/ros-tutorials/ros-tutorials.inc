SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "48bce9a889933e0b0edb2073a7133486"
SRC_URI[sha256sum] = "0cac1b15f2741c14a5adba7ea133ac30a1da5d82143ec3c2074273c29a97a980"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_tutorials"
