DESCRIPTION = "PCL (Point Cloud Library) ROS interface stack"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=19;endline=19;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "dynamic-reconfigure nodelet nodelet-topic-tools message-filters tf rosbag pcl pcl-conversions"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "29525781041520e5f9bcf165bc654223"
SRC_URI[sha256sum] = "f1da22f4b06e415e53b18a39094a10455f00efa92fe1301a918cde1ff87dcd7b"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "perception_pcl"
