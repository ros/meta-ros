SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9af26ae006a7111f8f546a5067d38f42"
SRC_URI[sha256sum] = "345e945c5401c494006885373c7658bed1f25bf4047838f4eb82dcda04b18bf2"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "bond_core"
