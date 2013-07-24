SRC_URI = "https://github.com/ros/common_msgs/archive/${PV}.tar.gz;downloadfilename=common_msgs-${PV}.tar.gz"
SRC_URI[md5sum] = "6259ec362103ed96abbcf7d67703aed5"
SRC_URI[sha256sum] = "54864270e973cec64f9315aed9e07f8d3837c409602dd18653c843c7a35690d0"

inherit catkin

S = "${WORKDIR}/common_msgs-${PV}/${ROS_BPN}"

DEPENDS = "cpp-common roscpp-serialization message-generation-native message-runtime-native std-msgs"
