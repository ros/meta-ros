SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d572249f578dd2a1753be77fd8d94107"
SRC_URI[sha256sum] = "9b9b98d27f6dda114b2ba59cb5963b7bf336154589d68c4a6c96cc090d1fc880"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "vision_opencv"
