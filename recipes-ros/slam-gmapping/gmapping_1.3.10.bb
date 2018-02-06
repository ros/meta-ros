DESCRIPTION = "This package contains a ROS wrapper for OpenSlam's Gmapping."
SECTION = "devel"
LICENSE = "CC-BY-NC-SA-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=11e24f757f025b2cbebd5b14b4a7ca19"

DEPENDS = "nodelet nav-msgs openslam-gmapping roscpp tf rosbag-storage"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b70ca310173d7234d7892f2ab7b21245"
SRC_URI[sha256sum] = "a4eae02f88d599bf34ed8d3865d37e276af22a644d4c45c3fe35d90a48378abc"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "slam_gmapping"
