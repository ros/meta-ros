SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8258067f0097e5a4355eda1b1cbaff04"
SRC_URI[sha256sum] = "e84a03be89650ed9e376b7e09ffe27cf7d1670e93e0e60cc2b59659a4aac7b20"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "rosserial"
