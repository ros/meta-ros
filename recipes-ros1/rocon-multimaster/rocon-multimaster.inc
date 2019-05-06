SRC_URI = "https://github.com/robotics-in-concert/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1b48d8efe8c69eeecc90a0e53329e8ac"
SRC_URI[sha256sum] = "eb5806aaab740a202c3e0f9f1899c9b5ce57cd8353f88028e95aa0bc2d966659"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "rocon_multimaster"
