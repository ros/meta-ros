SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e6d44439bd062a75ec15d8fd845a657c"
SRC_URI[sha256sum] = "9c1ca5fca90e59876782b92e4c67339ce2df84eedc5af4358c5a4b42c6aaed30"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "navigation"
