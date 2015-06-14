DESCRIPTION = "PCL (Point Cloud Library) ROS interface stack"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "dynamic-reconfigure nodelet nodelet-topic-tools message-filters tf rosbag pcl pcl-conversions"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f74e6ce65210062d2c8e2862f9594315"
SRC_URI[sha256sum] = "8df5fc33acb0bc659753311d49defd2603735f2cd27672e95d4247ef28c6d0f4"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "perception_pcl"
