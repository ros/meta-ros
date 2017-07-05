SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ca7bbf87061fea2b46963a3a358f2ab5"
SRC_URI[sha256sum] = "d3fc583d8e2b6733d91bc126069a831e3414550eec2bb20815c19d3e7ce2e96b"

DEPENDS += "cpp-common roscpp-serialization message-generation message-runtime std-msgs"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "common_msgs"
