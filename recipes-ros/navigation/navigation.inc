SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3ef134620bd407d547da7a8798dba598"
SRC_URI[sha256sum] = "349f0cfec19a545b7448e8dba1796a984210cebcd1c7d13827b74cdb436ddf7a"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "navigation"
