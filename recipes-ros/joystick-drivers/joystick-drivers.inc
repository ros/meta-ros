SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ded8d0f0eda389413a5fea470cc81ae2"
SRC_URI[sha256sum] = "b261fd559749135e7a3ce3d6a33e700a3631e2dc100456a6f66541ad3d6956ed"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "joystick_drivers"

