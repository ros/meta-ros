DESCRIPTION = "This package is a ROS wrapper for Alvar, an open source AR tag tracking library."
SECTION = "devel"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=061abe8dc89f326789675967c8760541"

DEPENDS = "ar-track-alvar-msgs cmake-modules cv-bridge image-transport libtinyxml pcl-ros resource-retriever roscpp tf visualization-msgs"

SRC_URI = "https://github.com/sniekum/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "37b0bc83cfc2f74cb44f21ec6e791b08"
SRC_URI[sha256sum] = "317c8b4a4be2d3d3c7dea4f7c8dbf84255efd18915846862cd6d2bbe48deadba"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
