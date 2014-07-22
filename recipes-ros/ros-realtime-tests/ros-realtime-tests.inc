SRC_URI = "https://github.com/bmwcarit/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8fbf5ff2bd671584da27272d45e11bc9"
SRC_URI[sha256sum] = "0b36c6ee0035ab8c5c5e048d6a66bd83a55bcfe1d8ec6150fa8e62cab9fc4c4d"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_realtime_tests"
