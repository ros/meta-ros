SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "01d9dc777a9a58800a0a6fc1bd9e5466"
SRC_URI[sha256sum] = "177dc78ef9cf3cd9f48fe5aca4742f504956c71641c75048b7559af0e2aacd53"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "bond_core"
