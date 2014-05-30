DESCRIPTION = "\
console_bridge is a ROS-independent, pure CMake package that provides logging \
calls that mirror those found in rosconsole, but for applications that are \
not necessarily using ROS.\
"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "\
  file://include/console_bridge/console.h;beginline=1;endline=33;md5=279eed49072cc9f6ebe38974afcc4803 \
  file://src/console.cpp;beginline=1;endline=33;md5=279eed49072cc9f6ebe38974afcc4803 \
"

DEPENDS = "boost"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "e484d34bf0170ee12311d0fc6dd5f4fe"
SRC_URI[sha256sum] = "d4bdd0b6bce0c6fa9ff18b8926d4953161451bc49dd11497211eb1a62cfe72b7"

S = "${WORKDIR}/${ROS_SP}"

inherit cmake ros faulty-solibs
