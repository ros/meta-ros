DESCRIPTION = "This package provides a set of simple math utilities to work with angles."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c2a841dbeb1f3036449919773ac70876"
SRC_URI[sha256sum] = "5e690bf611bead83c2fdcab5a9617b622a9869e55fd1742c00b4015ddf4f8cfc"

SRC_URI += "file://0001-check-for-CATKIN_ENABLE_TESTING.patch;striplevel=2"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin
