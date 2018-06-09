SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e971e992075229c73427df703b59d298"
SRC_URI[sha256sum] = "e00d185f377a9ceec964c475954c6f701179e6f9014b21fc74df8a88258afc3f"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_control"
