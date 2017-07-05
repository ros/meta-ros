SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c4b190c223f2ecc373b468ba51e508b7"
SRC_URI[sha256sum] = "34b5ff0e180dbe835ba5adf51fb5423ec292a1c8af716e55317ee04a52013c19"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "kdl_parser"
