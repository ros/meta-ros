SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ace0ad11052ce15a731b99745c1e7000"
SRC_URI[sha256sum] = "3cdda69d75763bd9f6669a416c8aec1c3bcd81e929fb7719c39e1acf41231f15"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_controllers"
