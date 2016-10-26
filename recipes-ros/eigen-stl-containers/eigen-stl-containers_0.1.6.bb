DESCRIPTION = "This package provides a set of typedef's that allow using Eigen datatypes in STL containers."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "fcc3fdda4010f92aa68f926cd3b8bdd0"
SRC_URI[sha256sum] = "24d614921c4ec97f1d5c7905f5e896f1665b2e796c547b4a21504176b4680e47"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
