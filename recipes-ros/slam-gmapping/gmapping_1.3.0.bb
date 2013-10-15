DESCRIPTION = "This package contains a ROS wrapper for OpenSlam's Gmapping."
SECTION = "devel"
LICENSE = "CC-BY-NC-SA-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=11e24f757f025b2cbebd5b14b4a7ca19"

DEPENDS = "nav-msgs openslam-gmapping roscpp rostest tf"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b2a91e7a1fcfbdaf16be64d6ea28f258"
SRC_URI[sha256sum] = "4035f9d0efc6820e6a3fbf255e8771ca0e890f5df36bc8d4f9b65ffb7fb5a702"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "slam_gmapping"
