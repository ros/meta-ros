DESCRIPTION = "This package is a ROS wrapper for Alvar, an open source AR tag tracking library."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "message-generation geometry-msgs std-msgs"

SRC_URI = "https://github.com/sniekum/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c82bf63ab8ab5630fedc29e872138fc9"
SRC_URI[sha256sum] = "27e4ebed675c79b41a545614f5a95798c1740e487b65fc45ac356c7298330a80"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
