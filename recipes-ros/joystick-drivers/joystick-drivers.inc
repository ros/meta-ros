SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ee61937e5418036c42f4b1d8d9ea08d2"
SRC_URI[sha256sum] = "b93291cfa9b29dde40b994b9ec4c2893a3004ed3d1dd00a5b350eaec96960b84"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "joystick_drivers"

