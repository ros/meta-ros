SRC_URI = "https://github.com/ros-industrial/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d1627c81221dfd88bfcf960914856e7b"
SRC_URI[sha256sum] = "d91b854d3cfed6d996a44c79d6978e335459d97dd5b467516839df5c71dc510d"

S = "${WORKDIR}/${ROS_SPN}-${PV}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_canopen"
