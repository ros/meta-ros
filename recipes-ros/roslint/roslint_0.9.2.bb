DESCRIPTION = "CMake lint commands for ROS packages"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7f71adcdf0d8ffcc726e443ffe548bdd"
SRC_URI[sha256sum] = "b1a77e8d3a2ee3a065f9d6aea11867650facda40263feda6451d581aa7696049"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
