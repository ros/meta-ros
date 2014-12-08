SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "dc175d131171d93428b6fc01890b1c9a"
SRC_URI[sha256sum] = "19c803b059604121a4e682b0d12e6345e03adc6f5f6a302caf7a8251617a5c38"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "rosserial"
