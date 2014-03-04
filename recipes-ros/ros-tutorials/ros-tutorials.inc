SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e4e8e31d3c8b47667101d4283e38ceca"
SRC_URI[sha256sum] = "f3b8bab93101d0cb48d925c57ed66d20664d0a91dd70f80f7d74667ff9a10e8e"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_tutorials"
