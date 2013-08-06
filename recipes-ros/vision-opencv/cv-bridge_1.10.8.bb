DESCRIPTION = "CvBridge converts between ROS Image messages and OpenCV images"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost opencv rosconsole sensor-msgs"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b023245036ff488a379ed704d066e6ee"
SRC_URI[sha256sum] = "e71e47e95a80027083248aff5856b627a0b1558cd547641ad738089610c54555"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "vision_opencv"
