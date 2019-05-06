SRC_URI = "https://github.com/ros-geographic-info/${ROS_SPN}/archive/${ROS_SP}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8c269b49460b47655c7d3d8e090d5355"
SRC_URI[sha256sum] = "8e5a6b8c63aae9d97a511034536c295f4229e93cc40e60988464dfc591f8564b"

DEPENDS += "cpp-common roscpp-serialization message-generation message-runtime std-msgs uuid-msgs geometry-msgs"

S = "${WORKDIR}/${ROS_SPN}-${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geographic_info"
