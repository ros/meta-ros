DESCRIPTION = "PCL (Point Cloud Library) ROS interface stack"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=19;endline=19;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "dynamic-reconfigure nodelet nodelet-topic-tools message-filters tf rosbag pcl pcl-conversions"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "32bba867a1b41d2c40921719be0ecde8"
SRC_URI[sha256sum] = "d918d1e04dbbeb0aa7aa4097081ae542280f3645e04d1d1ed74f5396a67ddb1f"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "perception_pcl"
