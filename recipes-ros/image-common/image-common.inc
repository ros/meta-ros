SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "4339a2bc7a7fca8dad6b6c0d7796204d"
SRC_URI[sha256sum] = "bcce381f5525fe4185b08c23cbf4f1ddf2bc86263cdb53a7938c6dbf596d8ecc"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_common"
