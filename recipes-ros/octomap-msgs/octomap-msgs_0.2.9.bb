DESCRIPTION = "This package provides messages and serializations / conversion for the OctoMap library."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "message-generation geometry-msgs std-msgs"

SRC_URI = "https://github.com/OctoMap/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6ffa1eebf7e41108b18522a2bc90ed77"
SRC_URI[sha256sum] = "86e1bfa6d4be8895ecf90fefb03b012978c54d1ee3bf20fe59925508507a899a"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
