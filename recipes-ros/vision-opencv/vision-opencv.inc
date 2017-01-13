SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "3a31b0f7feb39d043ad1b260811197c8"
SRC_URI[sha256sum] = "c075229b5e3877dd6bc4f28262182a7760245ba7b0471b6242a7d774d6d40c29"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "vision_opencv"
