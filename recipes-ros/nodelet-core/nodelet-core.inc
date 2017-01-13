SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "fd356be7e92f3425fc426209a928ad4a"
SRC_URI[sha256sum] = "65181dfe8070c9cd7ed2d16a9cb0204f2ab122fd3f960c4042a5cbf5566f6ede"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "nodelet_core"
