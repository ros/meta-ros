SRC_URI = "https://github.com/bmwcarit/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7bc5ff099f51dccae6a56c8b957152b6"
SRC_URI[sha256sum] = "92f19fc3f591fee7d35a92d1e74a8755f4755452dd146f00c78e738b298cc1c9"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_realtime_tests"
