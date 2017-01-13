DESCRIPTION = "This package provides messages and serializations / conversion for the OctoMap library."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "message-generation geometry-msgs std-msgs"

SRC_URI = "https://github.com/OctoMap/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "78ec34552f6161d543975fe40f1b717c"
SRC_URI[sha256sum] = "ead6be1199e0d5cf44765e3172e156394602817aad21ca59c22d7a4f678639e4"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
