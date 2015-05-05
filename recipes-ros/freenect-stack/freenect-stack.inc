SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6a360b208435b23ec1f55ffcfa5ec6b8"
SRC_URI[sha256sum] = "2e62ca45afacc1d0129bee3f2672f7b677315fc98317d1380cb74842025e0811"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "freenect_stack"
