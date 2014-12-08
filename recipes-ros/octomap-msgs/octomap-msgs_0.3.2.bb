DESCRIPTION = "This package provides messages and serializations / conversion for the OctoMap library."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "message-generation geometry-msgs std-msgs"

SRC_URI = "https://github.com/OctoMap/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "94179d8ffe356b153c84f6b9cf9823ea"
SRC_URI[sha256sum] = "9185a7150c3177111dec48e814ff0f42bfced3503471f7c578c6319a664f1af1"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
