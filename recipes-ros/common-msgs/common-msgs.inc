SRC_URI = "https://github.com/ros/common_msgs/archive/${PV}.tar.gz;downloadfilename=common_msgs-${PV}.tar.gz"
SRC_URI[md5sum] = "84fb70d6ba4c796903bb4b95b551e19a"
SRC_URI[sha256sum] = "a4a02bce606c3468dcc93abdc49fc855f0d81c90a56f24594f8fa691f9a6b776"

inherit catkin

S = "${WORKDIR}/common_msgs-${PV}/${ROS_BPN}"

DEPENDS = "cpp-common roscpp-serialization message-generation-native message-runtime-native std-msgs"
