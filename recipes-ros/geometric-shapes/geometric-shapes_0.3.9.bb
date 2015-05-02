DESCRIPTION = "This package contains generic definitions of geometric shapes and bodies."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "boost shape-msgs shape-tools octomap assimp libeigen qhull console-bridge random-numbers eigen-stl-containers resource-retriever"

SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "c8e43ebaa2bcb0a12a006ed61b265b74"
SRC_URI[sha256sum] = "fa16bd0a8311ebe9e0cd11fcb5a4f41039275cd7f1aeb88b0e8d4f983a2d13f7"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
