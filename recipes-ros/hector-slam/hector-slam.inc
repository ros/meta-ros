SRC_URI = "https://github.com/tu-darmstadt-ros-pkg/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b332574d38f500ed655d8df0b3016bd6"
SRC_URI[sha256sum] = "8675e34e21a348384c67fc873555030298735b23f49fecddf17748951082a80e"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "hector_slam"
