SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "530cbf52308427e15a0568f5226313aa"
SRC_URI[sha256sum] = "10a95045136510c1db5743481930ced6d164c6990d9e1a7c2afd9d6fa5062d02"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "geometry_experimental"
