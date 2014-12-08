SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c5a9abf8db49abfbb05cb3ed88ef1931"
SRC_URI[sha256sum] = "48f11db9a1be8accf6bce4dc20efa825f8fab1697d8620690eb51051ddd2c6b3"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "executive_smach"
