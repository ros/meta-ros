SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ccaadd38c183c2c257e75ac907868c87"
SRC_URI[sha256sum] = "30527d91f182478b7819a947237c92ce1effe61cd11d2d710e0408c971f2bc74"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry"
