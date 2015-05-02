SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "06ff1b7ec7cf4d0a7292f7ceec1a923b"
SRC_URI[sha256sum] = "df843e2b2d9515c8615d04450a5f238e8aeecc9ab3de2b095cbe4314ae8f6408"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "navigation"
