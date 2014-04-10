SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "84abf8a66c09e061b93f087a9f7d8560"
SRC_URI[sha256sum] = "2f4e4fd1351afdc8e0469730030566b03bd3f7308904ddf7593d3cf98797515d"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "diagnostics"
