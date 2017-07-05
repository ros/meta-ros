SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3a6a07a9a11b28074f2b2c6dba8e102e"
SRC_URI[sha256sum] = "7c3e8e564674cf4a21796d98ceb26e34d0750e53a3593d1fade44338eb45ae31"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "freenect_stack"
