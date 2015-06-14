SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "380dcc7fe8fdf76e4e88c05b234054a9"
SRC_URI[sha256sum] = "e4c45e4504ec9751c2f89fea9f1d4fcfeba563435a4445a299b153255705e793"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_comm_msgs"
