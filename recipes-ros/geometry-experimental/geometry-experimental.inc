SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f851990c58213775a2d4cb224f9f3dab"
SRC_URI[sha256sum] = "d9a2639225e86ef58db9bd308234c336f09c20ae4f3e5fc91fcb64b0bd002e2e"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry_experimental"
