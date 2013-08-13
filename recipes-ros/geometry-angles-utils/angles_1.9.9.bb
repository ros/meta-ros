DESCRIPTION = "This package provides a set of simple math utilities to work with angles."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c2a841dbeb1f3036449919773ac70876"
SRC_URI[sha256sum] = "5e690bf611bead83c2fdcab5a9617b622a9869e55fd1742c00b4015ddf4f8cfc"

SRC_URI += "https://github.com/bulwahn/${ROS_SPN}/commit/8b1879e93b8ae2f89df345edaf688521e5c0ab97.patch;striplevel=2;name=patch"
SRC_URI[patch.md5sum] = "d55c70b7328ed6e9d00d3185ddf4b0bf"
SRC_URI[patch.sha256sum] = "2b7303ca01e355680adadd18c3b97dfb1071715375c14a3759ad96f807fc09e5"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin
