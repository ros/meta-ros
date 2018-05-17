SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f45a5eb1af83f18c629f7731af537087"
SRC_URI[sha256sum] = "3b2d3bb7bb333b8685fa084e086c00a044803dac41ff58351161440931d23550"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "diagnostics"
