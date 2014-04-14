SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f3e4bb2e48e45d3414d7e08e109e8d1b"
SRC_URI[sha256sum] = "dea2425dadfe9315eceacbc8d49cdd8a19f4eb79bd95c030c2c8d261e04b5060"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "image_pipeline"
