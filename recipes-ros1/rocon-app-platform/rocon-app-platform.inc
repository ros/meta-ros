SRC_URI = "https://github.com/robotics-in-concert/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "defca2d4c405502249bd4888bee837f6"
SRC_URI[sha256sum] = "72eae53692744d04d580a549449d5346edf28a67f25265db3ba371f467b0a03a"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "rocon_app_platform"
