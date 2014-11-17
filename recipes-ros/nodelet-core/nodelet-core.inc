SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "0d5e42e92ff148c144dfce0e10334556"
SRC_URI[sha256sum] = "3c0d916b43ceec53f0de24b7441be08dc2ca6a92e91985eb1e38e89d955e5776"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "nodelet_core"
