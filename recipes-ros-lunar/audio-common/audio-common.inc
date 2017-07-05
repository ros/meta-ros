SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "93f710014398298bdd8403cd7cf2d084"
SRC_URI[sha256sum] = "c1cdb8cbf999020fb6c97f45de1ddb39fc4712dd7cf48e6a296e5b3a8695d336"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "audio_common"
