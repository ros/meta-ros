SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3afd0058ae7bc2868a5d086f7737465a"
SRC_URI[sha256sum] = "67d7f1cbfe1a007ba48aa477f722e185485006cbd0abdd1460f580d677f89643"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "bond_core"
