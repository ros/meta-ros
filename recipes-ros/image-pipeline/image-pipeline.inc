SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "655ceb0d966d7105679d8c96304b2537"
SRC_URI[sha256sum] = "76bda6a0179de44a65f51a14d1967b81d45fe4e71c167cde25bd273bc63d22e0"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_pipeline"
