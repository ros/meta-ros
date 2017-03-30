DESCRIPTION = "This package contains generic definitions of geometric shapes and bodies."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "boost shape-msgs octomap assimp libeigen qhull console-bridge random-numbers eigen-stl-containers resource-retriever visualization-msgs"

SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2a11cd903e581f4e9cef57551e3f284b"
SRC_URI[sha256sum] = "dc3e826930642d6a2e47e8847550c680d03649fa90ca521fa752ff01bd3b697c"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
