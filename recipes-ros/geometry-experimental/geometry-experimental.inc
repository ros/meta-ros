SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b60f166ea4dc68600984e43d176cd169"
SRC_URI[sha256sum] = "15db02c9d8a28f2b0b3f234306722b96339e42d88c32ebaa404af246304095a7"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry_experimental"
