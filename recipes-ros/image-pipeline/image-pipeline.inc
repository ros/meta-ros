SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1c13b6e63b31dc336b4f48825a3fb271"
SRC_URI[sha256sum] = "d7f68f40e937f47e49121442825c30d9af4fdab68d53cff23863f885956f90ae"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_pipeline"
