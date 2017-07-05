DESCRIPTION = "General ros communications used by the various zeroconf implementations."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "std-msgs message-generation"

SRC_URI = "https://github.com/stonier/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "38e89e637f855c2ea0e8cb65c02dfd08"
SRC_URI[sha256sum] = "a5bfd788bc2e2aefb07cb3a302a25cbeef2ce7e931a3a273cb1ae9669645a696"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
