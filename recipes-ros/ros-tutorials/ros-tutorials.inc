SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "4c849616fc689681a77bd86ee3943534"
SRC_URI[sha256sum] = "19a19adfe6cef123d5f7264c10c1ddc3a9f44b38d1ee2beb7180b90c054f6443"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "ros_tutorials"
