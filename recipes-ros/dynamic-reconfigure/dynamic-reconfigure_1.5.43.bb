DESCRIPTION = "This unary stack contains the dynamic_reconfigure package which provides a means to \
change node parameters at any time without having to restart the node."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp std-msgs roslib"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "4b28db549ad2b4aa49769683b2e990b0"
SRC_URI[sha256sum] = "84d9bf55353c1d816ed8a3b40d77ed933bb53493fadcc0826018c93138777b4c"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RDEPENDS_${PN} = "roslib rosservice"
