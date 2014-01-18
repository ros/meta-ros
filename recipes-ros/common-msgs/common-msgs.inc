SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "29442ade4217fbd14ea05991b2b24e46"
SRC_URI[sha256sum] = "dd6a05931485d6a58142c0baa8812f0f1bb6a3b2d42aa110ec2297f8ec9dbdbc"

DEPENDS += "cpp-common roscpp-serialization message-generation message-runtime std-msgs"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "common_msgs"
