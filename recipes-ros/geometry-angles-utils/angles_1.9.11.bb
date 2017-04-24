DESCRIPTION = "This package provides a set of simple math utilities to work with angles."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "58c8df0f95bd3c1c69d2cd5dd0432ff6"
SRC_URI[sha256sum] = "c453dc462585320e57e4086f47f3be618ec7a2e83610895ccfdbd31d5d4993f4"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin
