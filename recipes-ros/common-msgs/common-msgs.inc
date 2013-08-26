SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6259ec362103ed96abbcf7d67703aed5"
SRC_URI[sha256sum] = "54864270e973cec64f9315aed9e07f8d3837c409602dd18653c843c7a35690d0"

DEPENDS += "cpp-common roscpp-serialization message-generation-native message-runtime-native std-msgs"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "common_msgs"
