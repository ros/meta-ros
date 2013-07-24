SRC_URI = "https://github.com/ros/geometry_experimental/archive/${PV}.tar.gz;downloadfilename=geometry_experimental-${PV}.tar.gz"
SRC_URI[md5sum] = "530cbf52308427e15a0568f5226313aa"
SRC_URI[sha256sum] = "10a95045136510c1db5743481930ced6d164c6990d9e1a7c2afd9d6fa5062d02"

inherit catkin

S = "${WORKDIR}/geometry_experimental-${PV}/${ROS_BPN}"
