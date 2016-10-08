DESCRIPTION = "This package is a ROS wrapper for Alvar, an open source AR tag tracking library."
SECTION = "devel"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=061abe8dc89f326789675967c8760541"

DEPENDS = "ar-track-alvar-msgs cmake-modules cv-bridge image-transport libtinyxml pcl-ros resource-retriever roscpp tf visualization-msgs"

SRC_URI = "https://github.com/sniekum/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9f13592fbfcdfe7731227c87bd774877"
SRC_URI[sha256sum] = "519b89f6af09a703822864408195cdc55e8835b734c33ba38e6bab5849e9eadc"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
