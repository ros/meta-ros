DESCRIPTION = "This package contains a ROS wrapper for OpenSlam's Gmapping."
SECTION = "devel"
LICENSE = "CC-BY-NC-SA-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=11e24f757f025b2cbebd5b14b4a7ca19"

DEPENDS = "nav-msgs openslam-gmapping roscpp rostest tf"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e22b568b6d1c1066182785347e627f88"
SRC_URI[sha256sum] = "f9aa6b5fe940e5b399ce0fabfd7c809a6deb9cd42ca8e042abf25e50e9e33234"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin

ROS_SPN = "slam_gmapping"
