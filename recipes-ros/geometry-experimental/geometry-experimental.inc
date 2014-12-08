SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8d561c38e936c5dd646123ecff64a043"
SRC_URI[sha256sum] = "4e0defcfc1bece7e497bdec0c307e4b78af83e85fec298351b1b0c13fed8c4f5"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry_experimental"
