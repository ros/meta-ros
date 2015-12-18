SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a3f7456d092577b97f1bb1dfe86197e7"
SRC_URI[sha256sum] = "14b5a067791c74d922ab39fbf773a08fc98b3ca3d6f920c8798713e4e551711c"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_common"
