SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2c6daf8212856f002506c370095c28f8"
SRC_URI[sha256sum] = "f0047e40b1643ba128cf679a014a27790cfeb358bef768212ec932bb62a9b8c7"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "rosserial"
