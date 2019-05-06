DESCRIPTION = "This package contains generic definitions of geometric shapes and bodies."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "boost shape-msgs octomap assimp libeigen qhull console-bridge random-numbers eigen-stl-containers resource-retriever visualization-msgs"

SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9f125d76fb143f4206f2618f40f15d40"
SRC_URI[sha256sum] = "8998d5b4f23d4819ad92c2d37233cbd2dafe2480d689bffdbc666ed8e5c5aefa"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
