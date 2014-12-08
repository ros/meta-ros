SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e626ae457fec17f234f692782c80ea8a"
SRC_URI[sha256sum] = "7e223f235b0aa80437f93e729d0f8a1446a07941d8870590981f2562e78c1c1c"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_tutorials"
