SRC_URI = "https://github.com/ros-industrial/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "dfee31155f203178be7a7d537a75f162"
SRC_URI[sha256sum] = "ea66ce536c2f64c0bb3642d7c91df8e3f2e9b54e6ca102c97d6c7429becc8b85"

S = "${WORKDIR}/${ROS_SPN}-${PV}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_canopen"
