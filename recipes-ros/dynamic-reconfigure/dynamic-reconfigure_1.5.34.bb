DESCRIPTION = "\
This unary stack contains the dynamic_reconfigure package which provides a means to change \
node parameters at any time without having to restart the node."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "01664fe3856e604d0949247a7407bea4"
SRC_URI[sha256sum] = "24b8d019042eb7ccb095c1ed240da41b111e4c2ad1dcf8ac8ef190165d73fdce"

DEPENDS = "roscpp std-msgs roslib"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RDEPENDS_${PN} = "roslib rosservice"
