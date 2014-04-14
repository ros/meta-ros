DESCRIPTION = "\
This unary stack contains the dynamic_reconfigure package which provides a means to change \
node parameters at any time without having to restart the node."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "a6df76bcd6da3130043c792ff90f6a80"
SRC_URI[sha256sum] = "d27b6be763be88ec2a0eab946a9d55b1074ec4bcddb0da6d6ed90b81541487bd"

DEPENDS = "roscpp std-msgs roslib"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RDEPENDS_${PN} = "roslib rosservice"
