SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f622ca8ec2a85f5d854e06d0b64fc627"
SRC_URI[sha256sum] = "4e94b2087cad13f48534163f36bae47db1e09b388032f35e7e8eae270514719a"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "vision_opencv"
