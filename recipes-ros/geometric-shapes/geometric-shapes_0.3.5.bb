DESCRIPTION = "This package contains generic definitions of geometric shapes and bodies."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "boost shape-msgs shape-tools octomap assimp libeigen qhull console-bridge random-numbers eigen-stl-containers resource-retriever"

SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "7b7b803890baf1a5f27264a2906e3d9c"
SRC_URI[sha256sum] = "a26443007e39c7c6355c83d703df04969e8b60b7e44d851f44df026e168243c7"

SRC_URI += "file://0001-check-for-CATKIN_ENABLE_TESTING.patch;striplevel=1"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
