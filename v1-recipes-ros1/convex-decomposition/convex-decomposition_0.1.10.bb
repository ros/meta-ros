DESCRIPTION = "Convex Decomposition Tool for Robot Model"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=58e54c03ca7f821dd3967e2a2cd1596e"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "aff65d84fa5a5dd48769f226f9262d79"
SRC_URI[sha256sum] = "0c31ce26ecc73c5d53be18ddb01021d8d59cf5907397207b61b6ab7cfff167f4"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
