DESCRIPTION = "This unary stack contains the dynamic_reconfigure package which provides a means to \
change node parameters at any time without having to restart the node."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp std-msgs roslib"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ceddcb66706b328ca725218c2e2d4d3f"
SRC_URI[sha256sum] = "2f1160877ddd9f77d7cb9b9fc32479424fba4b973c08752437a56bb38a1e368c"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RDEPENDS_${PN} = "roslib rosservice"
