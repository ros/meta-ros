SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "93c0a54e8ccaae7fa959038f8333ecb8"
SRC_URI[sha256sum] = "9392597fc451c5e82e87794b3082a955fbb1d176fabf72f96bf3abcbb0b0f1a7"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "vision_opencv"
