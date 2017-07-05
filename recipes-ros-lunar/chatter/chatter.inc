SRC_URI = "https://github.com/bmwcarit/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3048507b90d31babed579677c73aa219"
SRC_URI[sha256sum] = "ff7f5a705049bd6e312afcbbf919cc5a382160ff6eca8571a7dec4f4e0bc8f15"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_chatter"
