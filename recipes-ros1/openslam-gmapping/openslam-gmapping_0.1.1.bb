DESCRIPTION = "ROS-ified version of gmapping SLAM."
SECTION = "devel"
LICENSE = "CC-BY-NC-SA-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=11e24f757f025b2cbebd5b14b4a7ca19"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "da2548abb3d351b199896dc62363ae65"
SRC_URI[sha256sum] = "b54235b197cfd0bb5ce4689310d1b52af838d4614ac37e5f03be18d53eb39683"

SRC_URI += "file://0001-make-it-compile-with-glibc-2.26-with-an-explicit-cas.patch"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
