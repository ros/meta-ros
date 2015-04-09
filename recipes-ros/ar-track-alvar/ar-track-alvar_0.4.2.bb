DESCRIPTION = "This package is a ROS wrapper for Alvar, an open source AR tag tracking library."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=f62de161dc7a8f859a0502707b17209e"

DEPENDS = "cmake-modules cv-bridge image-transport libtinyxml pcl-ros resource-retriever roscpp tf visualization-msgs"

SRC_URI = "git://github.com/sniekum/${ROS_SPN}.git;protocol=https;branch=hydro-devel"
# commit df56a7429 is intended to be version 0.4.2
SRCREV = "df56a742976712a1de7212039de8056c93b39375"

S = "${WORKDIR}/git"

inherit catkin
