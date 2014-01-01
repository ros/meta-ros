SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7b984f9560691f1405ed02b65f9698e2"
SRC_URI[sha256sum] = "c246aebe8ed725835a9d414700716a2124c596c486b5512b587df127295e33cb"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry"
