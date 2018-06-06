SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d1ddfbc6e0913dae9718d62ff3104cda"
SRC_URI[sha256sum] = "0b024f155f79f16982b31951ad0b1bde5440159b0ba6b1128ecbe2e867a2e357"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_pipeline"
