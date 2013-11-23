SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "dedd510c159dfdf26fc0fad10ff58818"
SRC_URI[sha256sum] = "439da90a7cb45afe4105f158adad3149a968414256b12162afa7a35e1c51d79c"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "vision_opencv"
