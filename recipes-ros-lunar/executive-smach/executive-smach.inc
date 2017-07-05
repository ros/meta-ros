SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e8c39c7fe0033e7512138b9c94649c73"
SRC_URI[sha256sum] = "2f7f58064c960fc56de15fdedfd883f62122bd44874787f13c8b4d8a77c45380"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "executive_smach"
