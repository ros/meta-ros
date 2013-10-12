DESCRIPTION = "This package provides a set of typedef's that allow using Eigen datatypes in STL containers."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6ceee153cf07b27c94cbadfab0a08c3e"
SRC_URI[sha256sum] = "7ae3464121d1e6da8cc2829fad78b39687f75905cb7b56ff8d9f967cacb09a7f"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
