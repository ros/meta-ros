SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c2d1473770d47d5f3354e183b3defb6a"
SRC_URI[sha256sum] = "430115ef4a3352e8b00596ff7406e6cb14fc1720250cf164754cf724c7f371c3"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry_experimental"
