SRC_URI = "https://github.com/ros/geometry/archive/${PV}.tar.gz;downloadfilename=geometry-${PV}.tar.gz"
SRC_URI[md5sum] = "e7df8e2b209881c3cf262c8ccf7598d5"
SRC_URI[sha256sum] = "862918e3997b90570c282f29b03a9f70b4a354f1447fdce8c8940666e1811239"

inherit catkin

S = "${WORKDIR}/geometry-${PV}/${ROS_BPN}"
