SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7a73f7d1f84ad0cb82297bcfd06dec29"
SRC_URI[sha256sum] = "dacc8dfb6a5b81268ee65bb52dc0a0ef7bd22ba46dc2f1e925d846849a657c47"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "vision_opencv"
