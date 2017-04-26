SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6ebfe9fc33837fcea079bcd7f3741eb5"
SRC_URI[sha256sum] = "9ec381e6589a663b03f8468d095599b90b14e102be221f9b19dc8b833dbc05bb"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin ros-insane

ROS_SPN = "moveit"
