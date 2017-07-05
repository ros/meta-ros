DESCRIPTION = "CMake lint commands for ROS packages"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "56b8b206876dea561895dfddf011ad20"
SRC_URI[sha256sum] = "7dae1d2a46bf8f5ca920aa90e1e070d8db53816fe4f7d93b28694075554aa9c6"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RDEPENDS_${PN} += "bash"
