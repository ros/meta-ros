SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "189489f51eea27b99209465e6dd35179"
SRC_URI[sha256sum] = "9e024a5a01a1995c04826ad41b563dfcfe5a7f5a66072d18f9de9727c628a3a0"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_pipeline"
