SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b4ec524761d1d2494f5901b77ad35f9b"
SRC_URI[sha256sum] = "ad79f48e0916490d2095ea9ea81a796a060553d4e60ba5b148b96a95369b8124"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "nodelet_core"
