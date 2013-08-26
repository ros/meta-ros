SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "49856e2d0e1006fb86822bedcc397af4"
SRC_URI[sha256sum] = "191eddac2aea2d8b6d5e5939d11b58972bb0e4ddfeca8d3e0938c156d1447c52"

DEPENDS += "cpp-common roscpp-serialization message-generation-native message-runtime-native std-msgs"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "common_msgs"
