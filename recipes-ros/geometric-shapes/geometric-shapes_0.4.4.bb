DESCRIPTION = "This package contains generic definitions of geometric shapes and bodies."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "boost shape-msgs shape-tools octomap assimp libeigen qhull console-bridge random-numbers eigen-stl-containers resource-retriever"

SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f684af3e76eb37b4c0153527162d73dc"
SRC_URI[sha256sum] = "4d600890b72d0b20b2fbcc9ded06464a37c871317445ec32d3858bd719b0aa02"

SRC_URI += "file://0001-address-gcc6-build-error-backport-for-0.4.4.patch"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
