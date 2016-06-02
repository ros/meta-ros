SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a85da2e856d54320d89dd95b9719cf78"
SRC_URI[sha256sum] = "1662f0c14e11a8079a0c1325813591ddf4bafae9605ee10a920f42f15dc1face"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry2"
