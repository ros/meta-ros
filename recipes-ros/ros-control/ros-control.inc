SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f3fa5aabaa68f4f23bb277f47746cfc4"
SRC_URI[sha256sum] = "598d6c28148764f328b87ef0c2533e49f9b4925a1457688f2715ce332fc82dfd"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_control"
