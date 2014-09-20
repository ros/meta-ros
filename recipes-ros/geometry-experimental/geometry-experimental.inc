SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3a1f1f5dc4d0196611ea0222079b8222"
SRC_URI[sha256sum] = "a01f439cb3a935f51aa20db686b3e4d7d2d446d8362435046fa10c375590534b"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry_experimental"
