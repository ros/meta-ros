SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "65e20a0b03e89c48d2de4625d8a40581"
SRC_URI[sha256sum] = "da6fddad4ebaff99d37bf7746bed9b8ea3e5ab5ce8af6bcc4faa22cbc68641d5"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "joystick_drivers"

