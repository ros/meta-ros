DESCRIPTION = "This package provides a set of typedef's that allow using Eigen datatypes in STL containers."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "libeigen"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1c259f56ba08d35e31c8c9126a894e2f"
SRC_URI[sha256sum] = "cf1bcd3253aff0eb032f6d74b9b3c322c99f75ee66bd7034daee8bb2d2a422fc"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
