DESCRIPTION = "This package is a ROS wrapper for Alvar, an open source AR tag tracking library."
SECTION = "devel"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=f62de161dc7a8f859a0502707b17209e"

DEPENDS = "ar-track-alvar-msgs cmake-modules cv-bridge image-transport libtinyxml pcl-ros resource-retriever roscpp tf visualization-msgs"

SRC_URI = "https://github.com/sniekum/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "5d55aaf9098c1b803f9ed93e3c5fbacd"
SRC_URI[sha256sum] = "b8c1c28afaf16c03f37067ae2653f5df7d0a15fdb75a27c0a2f4da9c2f89d92e"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
