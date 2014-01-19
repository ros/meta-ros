SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "98225960a1cb3f76c490c41d44913b42"
SRC_URI[sha256sum] = "f2ea608c5d909e7249817fdc0a7fea67945fbf12e0d24fdfa4dd095b86ea8a75"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "rosserial"
