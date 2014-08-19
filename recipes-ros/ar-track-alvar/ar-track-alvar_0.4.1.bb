DESCRIPTION = "This package is a ROS wrapper for Alvar, an open source AR tag tracking library."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=f62de161dc7a8f859a0502707b17209e"

DEPENDS = "cmake-modules cv-bridge image-transport libtinyxml pcl-ros resource-retriever roscpp tf visualization-msgs"

SRC_URI = "https://github.com/sniekum/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2786829c43437da2aa93eff77a4c862f"
SRC_URI[sha256sum] = "f87759a0a4decbf0da3ff9341e1aa6fcfdcaf302f0844d6ace371c7e5dc9e53e"

SRC_URI += "file://0001-used-cmake_modules-to-find-TinyXML.patch"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
