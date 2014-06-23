DESCRIPTION = "\
This unary stack contains the dynamic_reconfigure package which provides a means to change \
node parameters at any time without having to restart the node."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "38248b33c5c8bc6d97d8f9e3ae349016"
SRC_URI[sha256sum] = "5f2c978861d6273af9fc40ff53b457d15b871ea7276278dcbd3eb9ba70044da3"

DEPENDS = "roscpp std-msgs roslib"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RDEPENDS_${PN} = "roslib rosservice"
