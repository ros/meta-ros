DESCRIPTION = "PCL (Point Cloud Library) ROS interface stack"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "dynamic-reconfigure nodelet nodelet-topic-tools message-filters tf rosbag pcl pcl-conversions"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ee6f6a5720b6828ee6e0c8db7d6d30bb"
SRC_URI[sha256sum] = "fd995076d104e147a7be73828088217b89de70a3c9e7d01bd2f21a273ada9324"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "perception_pcl"
