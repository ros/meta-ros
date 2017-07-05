SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a5e9e0a164c569bea3b4a1a07d3b104f"
SRC_URI[sha256sum] = "a372f2225d6d9625dadc9dee817281a22dfb4b4dc8fd129ee1fb9375993bfd88"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry"
