DESCRIPTION = "This package contains a ROS wrapper for OpenSlam's Gmapping."
SECTION = "devel"
LICENSE = "CC-BY-NC-SA-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=11e24f757f025b2cbebd5b14b4a7ca19"

DEPENDS = "nav-msgs openslam-gmapping roscpp rostest tf"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "da3c1ec894314a469e93c344f01a9cd5"
SRC_URI[sha256sum] = "9ffc587372fa9bb0b966322977cfdfdb52f2233c0ce15c07fb1447148faec08d"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "slam_gmapping"
