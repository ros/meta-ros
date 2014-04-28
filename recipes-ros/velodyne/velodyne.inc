SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${ROS_SP}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "07caaeccf72dd910907369a4eadc0dca"
SRC_URI[sha256sum] = "6ca923f662679e3286f33a511c1fb267a59d5f73e37752e249a69de5902cf756"

S = "${WORKDIR}/${ROS_SPN}-${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "velodyne"
