DESCRIPTION = "This package contains a ROS wrapper for OpenSlam's Gmapping."
SECTION = "devel"
LICENSE = "CC-BY-NC-SA-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=11e24f757f025b2cbebd5b14b4a7ca19"

DEPENDS = "nav-msgs openslam-gmapping roscpp rostest tf"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f5ce250bea6e5798735ddba602e69815"
SRC_URI[sha256sum] = "35fb00bed65a11de5c901fd9b32608bf2fb172d2428779f06489837910b09684"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "slam_gmapping"
