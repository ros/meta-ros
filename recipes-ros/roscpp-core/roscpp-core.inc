SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a1ac46e1ba871f438701a471211599ba"
SRC_URI[sha256sum] = "cce0c60a9e0fdd4d4ccff06bcba7324be2e58eaa08e7907296b1b1e2c2c36aa3"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "roscpp_core"
