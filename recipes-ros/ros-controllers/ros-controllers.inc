SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "bc1fefe5b293d95e1491e04594907b72"
SRC_URI[sha256sum] = "407368e9bc7058b4baff400219613d157547c19394a3b139662d789c3a846feb"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_controllers"
