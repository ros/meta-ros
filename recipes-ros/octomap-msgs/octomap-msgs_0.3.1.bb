DESCRIPTION = "This package provides messages and serializations / conversion for the OctoMap library."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "message-generation geometry-msgs std-msgs"

SRC_URI = "https://github.com/OctoMap/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7a804a06a48278e32e9e297ec50affef"
SRC_URI[sha256sum] = "4a4138dbedc651a3effe8140482230a9a6db31078c08e4b1402a12487e720fb2"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
