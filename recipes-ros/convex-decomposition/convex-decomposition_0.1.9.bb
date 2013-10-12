DESCRIPTION = "Convex Decomposition Tool for Robot Model"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=58e54c03ca7f821dd3967e2a2cd1596e"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c3e3f14cec67ccfd2e569b025ffeb3b5"
SRC_URI[sha256sum] = "6f382de77af6fc8bf203338f6a95dd4f2603c6e4a5e30c47951cc53135f5a35f"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
