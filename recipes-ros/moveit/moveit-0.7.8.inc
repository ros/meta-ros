SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "fadd453134bb64559b989d2b3f02ca28"
SRC_URI[sha256sum] = "d14103ddf4545f42acaabfcdda36eeff9a293e07269d339eeb7ac4ab6dd3c522"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin ros-insane

ROS_SPN = "moveit"
