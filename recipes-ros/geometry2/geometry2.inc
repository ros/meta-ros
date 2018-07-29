SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "13e000c38d0917cc86f40b9d39d0e2b3"
SRC_URI[sha256sum] = "5c7fb96ebcb87b397473bdd3725e3848589ecc9a7036bc5e26267c7a57dece3d"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry2"
