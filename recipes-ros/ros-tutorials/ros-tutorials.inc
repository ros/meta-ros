SRC_URI = "https://github.com/ros/ros_tutorials/archive/${PV}.tar.gz;downloadfilename=ros_tutorials-${PV}.tar.gz"
SRC_URI[md5sum] = "e1763e2ccc91976ac98b07d3f423478d"
SRC_URI[sha256sum] = "827622a42eb14119c3303665c91635fd4c1eb401e1585a9f1fde819f7651bdbf"

S = "${WORKDIR}/ros_tutorials-${PV}/${ROS_BPN}"

inherit catkin
