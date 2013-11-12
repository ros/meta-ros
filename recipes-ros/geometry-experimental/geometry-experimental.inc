SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1f2cdfeff259e2e8d1b9e1c2e4b843a8"
SRC_URI[sha256sum] = "6ea32df2e15149a3654cb946d9a7c3fb192cdcf4504750ee51dbb0d524f3c4e3"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry_experimental"
